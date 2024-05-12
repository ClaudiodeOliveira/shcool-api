package com.claudio.school.utils;

import lombok.NoArgsConstructor;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

@NoArgsConstructor
public class MessageUtils extends org.springframework.util.StringUtils {

    public static String getMensagemValidacao(final String chaveMensagem, final Object... params){
        ResourceBundle bundle = ResourceBundle.getBundle("ValidationMessages", Locale.getDefault());
        String pattern = bundle.getString(chaveMensagem);
        return MessageFormat.format(pattern, params);
    }

}
