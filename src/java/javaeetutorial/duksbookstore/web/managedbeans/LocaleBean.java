/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaeetutorial.duksbookstore.web.managedbeans;

import java.io.Serializable;
import java.util.Locale;
import java.util.Map;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import org.jboss.logging.Logger;

/**
 *
 * @author desenvolvimento
 */
@Named
@SessionScoped
public class LocaleBean extends AbstractBean implements Serializable {

    private static final Logger logger = Logger.getLogger("javaeetutorial.duksbookstore.web.managedbeans.LocaleBeans");
    private Locale locale = context().getViewRoot().getLocale();

    public LocaleBean() {
    }

    public Locale getLocale() {
        logger.log(Logger.Level.INFO, "Enterign LocaleBean.getLocale");
        return locale;
    }

    public void setLocale(Locale locale) {
        logger.log(Logger.Level.INFO, "Entering LocaleBean.setLocale");
        this.locale = locale;
    }

    public String getLanguage() {
        Locale newLocale = null;
        logger.log(Logger.Level.INFO, "Enterign LocaleBean.getLanguage");
        String lang = locale.getLanguage();
        Map map = context().getExternalContext().getApplicationMap();
        if (map.containsKey("locale")) {
            newLocale = (Locale) map.get("locale");
        }
        if (!(newLocale == null)) {
            String newLang = newLocale.getLanguage();
            if (!newLang.equals(lang)) {
                return newLang;

            }

        }
        return lang;
    }
    
    
    public void setLanguage(String language){
    
    logger.log(Logger.Level.INFO, "Entering LocaleBean.setLanguage");
    locale = new Locale(language);
    context().getViewRoot().setLocale(locale);
    
    }
}
