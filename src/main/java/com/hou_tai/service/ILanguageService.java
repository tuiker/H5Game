package com.hou_tai.service;

import com.hou_tai.model.pojo.GameType;
import com.hou_tai.model.pojo.Language;

import java.util.List;

/**
 * @InterfaceName: LanguageService
 * @Description: 语言方法
 * @Author: Sam
 * @Date: 2023-11-04 11:37
 * @Version: 1.0
 **/
public interface ILanguageService {

    List<Language> list();

}
