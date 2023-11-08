package com.hou_tai.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hou_tai.model.dao.LanguageMapper;
import com.hou_tai.model.pojo.Language;
import com.hou_tai.service.ILanguageService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Sam
 * @Date:2023-10-18 13:41
 */
@Service
public class LanguageServiceImpl extends ServiceImpl<LanguageMapper, Language> implements ILanguageService {

    @Override
    public List<Language> listByLanguage() {
        return this.list();
    }
}
