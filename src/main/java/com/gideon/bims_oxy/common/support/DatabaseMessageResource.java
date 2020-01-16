package com.gideon.bims_oxy.common.support;

import java.text.MessageFormat;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractMessageSource;

import com.gideon.bims_oxy.common.service.I18nSo;

public class DatabaseMessageResource extends AbstractMessageSource {

	private MessageSource messageSource;

	@Autowired
	private I18nSo I18nSo;
	
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	@Override
	protected MessageFormat resolveCode(String code, Locale locale) {
		MessageFormat mf = null;

		String lang = locale.getLanguage();
		String message = I18nSo.getMessage(code, lang);

		if (message == null) {
			mf = new MessageFormat(code + "." + lang);
		} else {
			mf = new MessageFormat(message, locale);
		}

		return mf;
	}

}
