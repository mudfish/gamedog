package com.laoxu.gamedog.controller.product;

import com.laoxu.gamedog.config.UploadConfig;
import com.laoxu.gamedog.framework.Result;
import com.laoxu.gamedog.framework.ResultUtil;
import com.laoxu.gamedog.framework.pagination.BtPagingResult;
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
import java.util.ArrayList;
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
    public Result<String> upload(@RequestParam("file") MultipartFile file, @RequestParam("productId") Long productId) {
        if (file.isEmpty()) {
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
        Map<Integer, List<String>> result = null;
        try {
            result = ExcelPOIHelper.readExcel(targetLocation.toString(), fileExtensionName);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            return ResultUtil.fail("读取文件异常！" + e.getMessage());
        }

        if (result.size() == 0) {
            return ResultUtil.fail("文件为空！");
        }

        List<String> list = null;
        List<Card> cards = new ArrayList<>();
        String productName = "";
        //跳过第一行
        for (int i = 1; i < result.size(); i++) {
            list = result.get(i);
            if (list.size() != 2) {
                return ResultUtil.fail("文件列数不对！");
            }

            cards.add(new Card(productId, list.get(0), list.get(1)));
        }

        //插入表数据
        for (int i = 0; i < cards.size(); i++) {
            cardService.save(cards.get(i));
        }
        //返回处理结果
        return ResultUtil.ok();
    }


    /**
     * 保存
     *
     * @param product
     * @return
     */
    @PostMapping("/save")
    public Result<String> save(@RequestBody Card card, Principal principal) {
        if (principal == null) {
            return ResultUtil.fail("请登录后操作！");
        }

        cardService.save(card);

        return ResultUtil.ok();
    }

    /**
     * 获取卡密列表（分页）
     *
     * @return
     */
    @GetMapping("/list")
    public BtPagingResult<Map<String, Object>> list(@RequestParam("limit") Integer limit,
                                                          @RequestParam("offset") Integer offset,
                                                          @RequestParam("s_productId") Long productId,
                                                          @RequestParam("s_cardNo") String cardNo) {
        List<Map<String, Object>> cards = cardService.list(limit,offset,productId,cardNo);

        BtPagingResult<Map<String, Object>> result = new BtPagingResult<>(cards);

        return result;
    }

    /**
     * 获取商品
     *
     * @return
     */
    @GetMapping("/load")
    public Result<Card> load(@RequestParam("id") Long id) {
        Card card = cardService.load(id);

        return ResultUtil.ok(card);
    }

    /**
     * 删除单条商品
     *
     * @param id
     * @return
     */
    @PostMapping("/remove")
    public Result<String> removeProductType(@RequestParam("id") Long id) {
        cardService.remove(id);

        return ResultUtil.ok();
    }

    /**
     * 删除多条商品
     *
     * @param ids
     * @return
     */
    @PostMapping("/removes")
    public Result<String> removes(@RequestParam("ids") Long[] ids) {
        cardService.remove(ids);

        return ResultUtil.ok();
    }

}
