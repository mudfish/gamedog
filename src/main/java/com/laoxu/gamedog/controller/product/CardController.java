package com.laoxu.gamedog.controller.product;

import com.laoxu.gamedog.config.UploadConfig;
import com.laoxu.gamedog.framework.Result;
import com.laoxu.gamedog.framework.ResultUtil;
import com.laoxu.gamedog.model.product.Card;
import com.laoxu.gamedog.service.product.CardService;
import com.laoxu.gamedog.util.ExcelPOIHelper;
import com.laoxu.gamedog.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 商品管理-卡密-控制器
 *
 * @author xusucheng
 * @create 2018-11-14
 **/
@RestController
@RequestMapping("/card")
public class CardController {
    @Autowired
    private CardService cardService;

    @Autowired
    private UploadConfig uploadConfig;

    @PostMapping("/upload")
    public Result<String> upload(@RequestParam("file") MultipartFile file, @RequestParam("productId") Long productId){
        if(file.isEmpty()){
            return ResultUtil.fail("文件为空！");
        }
        //获取上传路径
        String uploadPath = FileUtil.getUploadPath(uploadConfig);
        //获取文件名
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        //生成随机文件名
        String fileExtensionName = FileUtil.getExtFromFileName(fileName);
        //生成随机文件名
        String randomFileName = FileUtil.createRandomFileName(fileExtensionName);
        //创建文件绝对路径
        Path targetLocation = Paths.get(uploadPath + File.separator + randomFileName, new String[0]);
        //存储文件
        try {
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //读取文件
        Map<Integer,List<String>> result=null;
        try {
            result = ExcelPOIHelper.readExcel(targetLocation.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(result.size()==0){
            return ResultUtil.fail("文件为空！");
        }else {
            List<String> list = null;
            for (int i = 0; i < result.size(); i++) {
                list=result.get(i);
                System.out.println(list);
            }
        }
        //插入表数据
        //返回处理结果

        return ResultUtil.ok();
    }


    /**
     * 保存商品
     * @param card
     * @return
     */
    @PostMapping("/save")
    public Result<String> save(@RequestBody Card card, Principal principal){
        if(principal==null){
            return ResultUtil.fail("请登录后操作！");
        }

        if(card.getId()==null){
            card.setCreater(principal.getName());
            card.setCreateTime(new Date());
        }

        card.setUpdater(principal.getName());
        card.setUpdateTime(new Date());

        cardService.save(card);

        return ResultUtil.ok();
    }


    /**
     * 获取商品列表
     * @return
     */
    @GetMapping("/list")
    public List<Map<String,Object>> list(){
        List<Map<String,Object>> products = cardService.list();

        return products;
    }

    /**
     * 获取商品
     * @return
     */
    @GetMapping("/load")
    public Result<Card> load(@RequestParam("id") Long id){
        Card card = cardService.load(id);

        return ResultUtil.ok(card);
    }

    /**
     * 删除单条商品
     * @param id
     * @return
     */
    @PostMapping("/remove")
    public Result<String> removeProductType(@RequestParam("id") Long id){
        cardService.remove(id);

        return ResultUtil.ok();
    }

    /**
     * 删除多条商品
     * @param ids
     * @return
     */
    @PostMapping("/removes")
    public Result<String> removes(@RequestParam("ids") Long[] ids){
        cardService.remove(ids);

        return ResultUtil.ok();
    }

}
