package br.com.secharpe.util;

import java.io.File;

/**
 *
 * @author luandr
 */
public final class Vars {

    //LANG
    public static final String[] LANG_LIST = {"br", "us", "es"};
    public static final String[] LANG_LIST_FULLNAME = {"Português", "English", "Español"};
    public static String LANG_DEFAULT = br.com.secharpe.util.Propriedades.getLang();

    //PROP
    public static String PROP_PATH = "src" + File.separator + "br" + File.separator + "com" + File.separator + "secharpe" + File.separator + "util" + File.separator + "lang" + File.separator;
    public static String PROP_FILE = PROP_PATH + Vars.LANG_DEFAULT + ".properties";

    //GLOBALS
    public static final String PROP_NEW = br.com.secharpe.util.Propriedades.getProp("form.new");
    public static final String PROP_REMOVE = br.com.secharpe.util.Propriedades.getProp("form.remove");
    public static final String PROP_EDIT = br.com.secharpe.util.Propriedades.getProp("form.edit");
    public static final String PROP_CLOSE = br.com.secharpe.util.Propriedades.getProp("form.close");
    public static final String PROP_VIEW = br.com.secharpe.util.Propriedades.getProp("form.view");
    public static final String PROP_SAVE = br.com.secharpe.util.Propriedades.getProp("form.save");
    public static final String PROP_ERASE = br.com.secharpe.util.Propriedades.getProp("form.erase");
    public static final String PROP_SAVECOMPANY = br.com.secharpe.util.Propriedades.getProp("form.savecompany");
    public static final String LOGIN_ENTER = br.com.secharpe.util.Propriedades.getProp("login.enter");
    public static final String PATH_TO_ICON_FOLDER = "/br/com/secharpe/util/image/";
    public static final String TITLE_MESSAGE_DEFAULT = "Ooops, um erro ocorreu!";

}
