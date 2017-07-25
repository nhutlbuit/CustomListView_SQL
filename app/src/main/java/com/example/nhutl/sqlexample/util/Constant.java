package com.example.nhutl.sqlexample.util;

public class Constant {

	public static final int CONNECTION_TIMEOUT = 30000;
	public static final String EXTRA_URL_DOWNLOAD = "extra_url_download";
	public static final String URL_HOST = "http://retailprotest.maple.com.vn";
	public static final String URL_PORT = "80";
	public static final String DB_NAME = "MAPLEPOS.db";
	public static final int DB_VERSION = 1;
	public static int RESULT_CODE_OK = 1;
	public static int RESULT_CODE_FAIL = 0;
	public static String CATEGORY = "CATEGORY";
	public static String TAG = "TAG";
	public static String TYPE = "TYPE";
	public static String TITLE = "TITLE";
	public static String BITMAP = "BITMAP";
	public static String IS_EDTING = "EDITING";
	public static String CATEGORY_ID = "CATEGORY_ID";
	public static String GROUP_ID = "GROUP_ID";
	public static String GROUP = "GROUP";
	public static String PRODUCT = "PRODUCT";
	public static String INVOICE_DETAIL = "INVOICE_DETAIL";
	public static String CUSTOM_PRODUCT = "CUSTOM_PRODUCT";
	public static String PRODUCT_PRICE = "PRODUCT_PRICE";
	public static String DISCOUNT = "DISCOUNT";
	public static String CUSTOM_DISCOUNT = "DISCOUNT";
	public static String DISCOUNTS = "DISCOUNTS";
	public static String PRICE_LEVEL = "PRICE_LEVEL";
	public static String IS_PERCENT = "IS_PERCENT";
	public static String PRICE = "PRICE";
	public static String LIST_PRICE_LEVEL = "LIST_PRICE_LEVEL";
	public static String ITEM_TYPE = "ITEM_TYPE";
	public static String ITEM = "ITEM";
	public static String TAX = "TAX";
	public static String INVOICE = "INVOICE";
	public static String LIST_INVOICE = "LIST_INVOICE";
	public static String STAFF = "STAFF";
	public static String CHANGE = "CHANGE";
	public static String TOTAL_AMOUNT = "TOTAL_AMOUNT";
	public static String REFERENCE = "REFERENCE";
	public static String FILENAME = "FILENAME";
	public static String INVOICE_ID = "INVOICE_ID";
	public static String CUSTOMER = "CUSTOMER";
	public static String EMAIL = "EMAIL";
	public static String AMOUT = "AMOUNT";
	public static String REFUND = "REFUND";
	public static String SEARCH = "SEARCH";
	public static String NUMBER = "NUMBER";
	public static String HINT = "HINT";
	public static String LIST_MODIFIER = "MODIFIES";
	public static String MODIFIER_NAME = "MODIFIER_NAME";
	public static String START_DRAWERID = "START_DRAWERID";
	public static String MODIFIERID = "MODIFIERID";
	public static String ENDDRAWER = "ENDDRAWER";
	public static String MODIFIERNAME = "MODIFIERNAME";
	public static String MODIFIER = "MODIFIER";
	public static String FOLDER_IMAGE = "MPOSDataImages";
	public static String FOLDER_TEMP = "MPOSTEMP";
	public static String FOLDER_BACKUP = "MPOSDataBackup";
	public static String FOLDER_PRODUCT = "MPOSDataProduct";
	public static String FOLDER_REPORT = "MPOSFileExport";
	public static String FILE_BACKUP = "Backup";
	public static final String IMAGE_CACHE_DIR = "list_lru";
	public static final String GRID_IMAGE_CACHE_DIR = "grid_lru";
	public static final String PRICELEVEL_NAME_DEFAULT = "Default";
	public static final int DEFAULT_FONT_SIZE = 12;
	public static final int HEADER_FONT_SIZE = 14;
	public static final float LIMIT_PRICE = 1000000000;

	public static String FROMDATE = "FROMDATE";
	public static String TODATE = "TODATE";

	public static final String ADMIN_NAME = "ADMIN";
	public static final String ADMIN_USERNAME = "ADMIN";
	public static final String ADDMIN_PASSWORD = "";

	public static String PATH_RETURN = "...";
	public static String PATH = "PATH";

	public static String ICMP_TRANS_C = "C Credit";
	public static String ICMP_TRANS_D = "D Debit";

	public static int img_big = 200;
	public static int img_normal = 60;
	public static int img_small = 40;
	public static int scale_corner = 0;

	public static int img_logo_width = 200;
	public static int img_logo_height = 200;
	public static int recf_logo_width = 576;
	public static int recf_logo_height = 200;
	public static float round_off = (float) 0.05;

	public static String DATE_FORMAT_YMD_HHMM = "EEE, d MMM yyy HH:mm";
	public static String DATE_FORMAT_YMD = "EEE, d MMM yyyy";
	public static String DATE_FORMAT_EXPIRI = "yyyy-MM-dd'T'HH:mm:ss";
	public static String DATE_FULL_FORMAT = "yyyy-MM-dd HH:mm:ss";

	public static enum ItemType {
		TYPE_DISCOUNT(1, "TYPE_DISCOUNT"), TYPE_ITEM(2, "TYPE_ITEM"), TYPE_CATEGORY(
				3, "TYPE_CATEGORY"), TYPE_DISCOUNTS(4, "TYPE_DISCOUNTS"), TYPE_CUSTOM_ITEM(
				5, "TYPE_CUSTOM_ITEM"), TYPE_CUSTOM_DISCOUNT(6,
				"TYPE_CUSTOM_DISCOUNT");
		private int value;
		private String name;

		private ItemType(int value, String name) {
			this.value = value;
			this.name = name;
		}

		private ItemType() {
			this.value = 0;
		}

		public int getValue() {
			return value;
		}

		public String getName() {
			return name;
		}
	}

	public static enum API_ID {
		API_ID_INSERT_ACTIVATION_CODE(1), API_ID_CHECK_ACTIVATION_CODE(2);
		private int value;

		private API_ID(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}

	}

	public static enum ACT_ID {
		ACT_ID_ADD_CATEGOTY(1), ACT_ID_ADD_IMAGE(2), ACT_ID_EDIT_CATEGOTY(3), ACT_ID_ADD_PRODUCT(
				4), ACT_ID_ADD_EDIT_PRICE_LEVEL(5), ACT_ID_EDIT_PRODUCT(6), ACT_ID_ADD_PRODUCT_FROM_PAPER(
				7), ACT_ID_EDIT_PRODUCT_FROM_PAPER(8), ACT_ID_ENABLE_EDIT_PRODUCT(
				9), ACT_ID_DONE_EDIT_PRODUCT(10), ACT_ID_ADD_DISCOUNT(11), ACT_ID_EDIT_DISCOUNT(
				12), ACT_ID_CALCULATOR(13), ACT_ID_CHOOSE_PRICE_LEVEL(14), ACT_ID_ADD_ITEM_TO_GRID(
				15), ACT_ID_CHOOSE_PRODUCT_IN_CATEGORY(16), ACT_ID_CHOOSE_DISCOUNT(
				17), ACT_ID_ADD_CUSTOM_PRODUCT(17), ACT_ID_ADD_CUSTOM_DISCOUNT(
				18), ACT_ID_ADD_TAX(19), ACT_ID_EDIT_TAX(20), ACT_ID_ADD_GROUP(
				21), ACT_ID_EDIT_GROUP(22), ACT_ID_EDIT_INVOICE_DETAIL(23), ACT_ID_CHANGE_INVOICE(
				24), ACT_ID_CHARGE_INVOICE(25), ACT_ID_ADD_LOGO(26), ACT_ID_ADD_STAFF(
				27), ACT_ID_EDIT_STAFF(28), ACT_ID_SELECT_DISCOUNT(29), ACT_ID_SAVE_INVOICE(
				30), ACT_ID_RETRIEVE_INVOICE(31), ACT_ID_EDIT_INVOICE_DISCOUNT(
				32), ACT_ID_ADD_MEMBER(33), ACT_ID_EDIT_MEMBER(34), ACT_ID_PRINT_RECEIPT(
				35), ACT_ID_ISSUE_REFUND(36), ACT_ID_SEARCH_PRODUCT(37), ACT_ID_SEARCH_CUSTOMER(
				38), ACT_ID_CHECKOUT(39), ACT_ID_TENDER(40), ACT_ID_NEW_ORDER(
				41), ACT_ID_EDIT_MODIFIER(42), ACT_ID_ADD_COST(43), ACT_ID_ADD_PRICE(
				44), ACT_ID_ADD_NUMBER_DISCOUNT(45), ACT_ID_CALCULATOR_MODIFIER(
				46), ACT_ID_ADD_MEMBER_FROM_MAIN(47), ACT_ID_DO_BACK(48), ACT_ID_CHANGE_PAYMENT(
				49), ACT_ID_SEARCH_PAPER(50), ACT_ID_ON_REMOVE(51), ACT_ID_ADD_MODIFIER(
				52), ACT_ID_ADD_GROUP_BY_SETTING(53), ACT_ID_EDIT_GROUP_BY_SETTING(
				54), ACT_ID_CALCULATOR_FROM_OPERATION(55), ACT_ID_EDIT_MEMBER_FROM_MAIN(
				56), ACT_ID_SELECT_FOLDER(57), ACT_ID_CROP_IMAGE(58), ACT_ID_ADD_STARTING_CASH(
				59), ACT_ID_PAID(60), ACT_ID_END_DRAWER(61), ACT_ID_DRAWER_HISTORY_DETAIL(
				62), ACT_ID_ADD_DEFAULT_STARTING_CASH(63), ACT_ID_SETTING_END_DRAWER(
				64), ACT_ID_SELECT_FILE(65), ACT_ID_ADD_EMAIL_RECIPIENT(66), ACT_ID_SELECT_FILE_RESTORE_LOCAL(
				68), ACT_ID_SELECT_FILE_RESTORE_DRIVE(69), ACT_ID_SELECT_FOLDER_BACKUP_LOCAL(
				70), ACT_ID_CROP_LOGO(71), ACT_ID_SELECT_FOLDER_X_REPORT(72), ACT_ID_SELECT_FOLDER_Y1_REPORT(
				73), ACT_ID_SELECT_FOLDER_Y2_REPORT(74), ACT_ID_SELECT_FOLDER_Z_REPORT(
				75), ACT_ID_SELECT_FOLDER_INVENTORY_REPORT(76), ACT_ID_SELECT_FOLDER_MIN_STOCK_REPORT(
				77), ACT_ID_DELETE_INVOICE(78), REQUEST_CODE_RESOLUTION(79), ACT_ID_SELECT_FOLDER_BACKUP_PRODUCT_LOCAL(
				80), ACT_ID_SELECT_FILE_RESTORE_PRODUCT_LOCAL(81), ACT_ID_SELECT_FILE_RESTORE_PRODUCT_DRIVE(
				82), ACT_ID_FILE_NAME_BACKUP_LOCAL(83), ACT_ID_FILE_NAME_BACKUP_EMAIL(
				84), ACT_ID_FILE_NAME_BACKUP_DRIVE(85), ACT_ID_FILE_NAME_BACKUP_PRODUCT_LOCAL(
				86), ACT_ID_FILE_NAME_BACKUP_PRODUCT_EMAIL(87), ACT_ID_FILE_NAME_BACKUP_PRODUCT_DRIVE(
				88), ACT_ID_ADD_EMAIL_RECIPIENT_EXPORT(89), ACT_ID_FASTCHECKOUT(
				90), ;
		private int value;

		private ACT_ID(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}

	}

	public static enum PaymentType {
		TYPE_CASH("Cash"), TYPE_CREDIT_CARD("Credit Card"), TYPE_DEBIT_CARD(
				"Debit Card"), TYPE_BANK_CARD("Bank Card"), TYPE_QR_CODE(
				"QR Code"), TYPE_MPOS("mPOS"), TYPE_NETS("NETS");
		private String name;

		private PaymentType(String name) {

			this.name = name;
		}

		private PaymentType() {

		}

		public String getName() {
			return name;
		}
	}

	public static enum RefundType {
		TYPE_RETURNED_GOOD("Returned Good"), TYPE_CANCEL_ORDER("Cancel Order"), TYPE_ACCIDENTAL_CHARGE(
				"Accidental Charge"), TYPE_OTHER("Other");
		private String name;

		private RefundType(String name) {

			this.name = name;
		}

		private RefundType() {

		}

		public String getName() {
			return name;
		}
	}

	public static enum PaidType {
		TYPE_PAID_IN("Paid In"), TYPE_PAID_OUT("Pain Out");
		private String name;

		private PaidType(String name) {

			this.name = name;
		}

		private PaidType() {

		}

		public String getName() {
			return name;
		}
	}

	public static enum mPOSType {
		TYPE_MC_PAYMENT("MC_PAYMENT"), TYPE_ICM_PAYMENT("iCMP_PAYMENT");
		private String name;

		private mPOSType(String name) {

			this.name = name;
		}

		public String getName() {
			return name;
		}
	}

}
