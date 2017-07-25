package com.example.nhutl.sqlexample.db;

/**
 * Created by nhutl on 7/23/2017.
 */

public class DBTable {

    public static class SettingOtherTable {
        public static final String NAME = "tbl_SettingOther";//
        public static final String DATEFORMAT = "StringDateFormat";//
        public static final String MONEYFORMAT = "StringMoneyFormat";//
        public static final String QUANTITYFORMAT = "StringQuantityFormat";//
        public static final String EMAISERVER = "EmailServer";//
        public static final String PASSWORD = "Password";//
        public static final String SERVERNAME = "ServerName";//
        public static final String SMTPPORD = "SMTPPort";//
        public static final String PREFIX = "PrefixReceipt";//
        public static final String SUFFIXLENGTH = "SuffixLength";//
        public static final String ISSSL = "ISSSL";//
    }

    public static class ScannerSelected {
        public static final String NAME = "tbl_Scanner";//
        public static final String SCANNER_ID = "ScannerID";//
        public static final String SCANNER_NAME = "ScannerName";//
        public static final String ID = "1";
    }

    public static class InventoryChangeTable {
        public static final String NAME = "tbl_InventoryChange";//
        public static final String PRODUCT_ID = "Product_ID";//
        public static final String PRODUCT_NAME = "Product_NAME";//
        public static final String NEW_INVENTORY = "NewInventory";//
        public static final String OLD_INVENTORY = "OldInventory";//
        public static final String DATE_CHANGE = "DateChange";//
    }

    public static class SettingMPOSTable {
        public static final String NAME = "tbl_SettingMPOS";//
        public static final String MPOSTYPE = "MPOSType";//
        public static final String MCPAYMENT_PASSWORD = "MCPaymentPassword";//
    }

    public static class SettingHardwareTable {
        public static final String NAME = "tbl_SettingHardware";//
        public static final String AUTOPRINT = "AutoPrint";//
        public static final String AUTOOPENCASH = "AutoOpenCash";//
        public static final String SCANNERSELECT = "ScannerSelect";//
        public static final String PRINTIMAGE = "PrintImage";//
        public static final String PRINTLOGO = "PrintLogo";
    }

    public static class SettingCashManagementTable {
        public static final String NAME = "tbl_SettingCashManagement";//
        public static final String CASHMANAGEMENT = "CashManagement";//
        public static final String CASHDEFAULT = "CashDefault";//
        public static final String AUTOSENDEMAIL = "AutoSendEmail";//
        public static final String RECIPIENT = "Recipient";//
    }

    public static class PaidTable {
        public static final String NAME = "tbl_Paid";//
        public static final String PAID_ID = "PaidID";//
        public static final String START_DRAWERID = "StartDrawerID";//
        public static final String AMOUNT = "Amount";//
        public static final String DATE = "TIME";//
        public static final String DESCRIPTION = "Description";//
        public static final String TYPE = "Type";//
    }

    public static class StartDrawerTable {
        public static final String NAME = "tbl_StartDrawer";//
        public static final String START_DRAWERID = "StartDrawerID";//

        public static final String START_OF_DRAWER = "StartOfDrawer";//
        public static final String STARTING_CASH = "StartingCash";//
    }

    public static class EndDrawerTable {
        public static final String NAME = "tbl_EndDrawer";//
        public static final String START_DRAWERID = "StartDrawerID";//
        public static final String END_DRAWERID = "EndDrawerID";
        public static final String DESCRIPTION = "Description";//
        public static final String START_OF_DRAWER = "StartOfDrawer";//
        public static final String STARTING_CASH = "StartingCash";//
        public static final String CASH_SALES = "CashSales";//
        public static final String CASH_REFUND = "CashRefund";//
        public static final String PAID = "Paid";//
        public static final String EXPECTED_DRAWER = "ExpectedDrawer";//
        public static final String ACTUAL_DRAWER = "ActualDrawer";//
        public static final String IS_CLOSED = "IsClosed";//
    }

    public static class TaxTable {
        public static final String NAME = "tbl_Tax";//
        public static final String TAX_ID = "TaxID";//
        public static final String TAX_NAME = "TaxName";//
        public static final String TAX_NUMBER = "TaxNumber";//
        public static final String IS_TAX_INCLUDE = "TaxInclude";//
        public static final String IS_SERVICE_TAX = "ServiceTax";//
        public static final String IS_ACTIVE = "IsActive";

    }

    public static class DriveTable {
        public static final String NAME = "tbl_Drive";//
        public static final String FILE_NAME = "FileName";//

    }

    public static class CategoryTable {
        public static final String NAME = "tbl_Category";//
        public static final String CATEGORY_ID = "CategoryID";//
        public static final String CATEGORY_NAME = "CategoryName";//
        public static final String CATEGORY_IMAGE = "Image";//
        public static final String IS_ACTIVE = "IsActive";
    }

    public static class DiscountTable {
        public static final String NAME = "tbl_Discount";//
        public static final String DISCOUNT_ID = "DiscountID";//
        public static final String DISCOUNT_NAME = "DiscountName";//
        public static final String DISCOUNT_NUMBER = "Number";//
        public static final String IS_PERCENT = "IsPercent";//
        public static final String IS_ACTIVE = "IsActive";//
    }

    public static class GroupTable {
        public static final String NAME = "tbl_Group";//
        public static final String GROUP_ID = "GroupID";//
        public static final String GROUP_NAME = "GroupName";//
        public static final String GROUP_IS_ACTIVE = "IsActive";//
    }

    public static class GroupDetailTable {
        public static final String NAME = "tbl_GroupDetail";//
        public static final String GROUP_DETAIL_ID = "GroupDetailID";//
        public static final String GROUP_ID = "GroupID";//
        public static final String ITEM_ID = "ItemID";//
        public static final String ITEM_POSITION = "Position";//
        public static final String ITEM_TYPE = "Type";//

    }

    public static class ProductTable {
        public static final String NAME = "tbl_Product";//
        public static final String PRODUCT_ID = "ProductID";//
        public static final String CATEGORY_ID = "CategoryID";//
        public static final String PRODUCT_NAME = "ProductName";//
        public static final String DESCRIPTION = "Description";//
        public static final String IMAGE = "Image";//
        public static final String GSTID = "GSTTaxID";///
        public static final String SERVICE_CHARGE = "ServiceChargeID";//
        public static final String STORE_ID = "StoreID";//
        public static final String IS_STOCK = "IsStock";//
        public static final String INVENTORY_LEVEL = "InventoryLevel";//
        public static final String INVENTORY_MIN = "InventoryMin";//
        public static final String DISCOUNT_AMOUNT = "DiscountAmount";//
        public static final String DISCOUNT_PERCENT = "DiscountPercent";//
        public static final String IS_ACTIVE = "IsActive";//

    }

    public static class ModifierProductTable {
        public static final String NAME = "tbl_ModifierProduct";//
        public static final String MODIFIER_ID = "ModifierID";//
        public static final String PRODUCT_ID = "ProductID";//
    }

    public static class ModifierTable {
        public static final String NAME = "tbl_Modifier";//
        public static final String MODIFIER_ID = "ModifierID";//
        public static final String MODIFIER_NAME = "ModofierName";//
        public static final String IS_ACTIVE = "Active";//
    }

    public static class ModifierDetailTable {
        public static final String NAME = "tbl_ModifierDetail";//
        public static final String MODIFIER_ID = "ModifierID";//
        public static final String MODIFIER_DETAIL_ID = "ModifierDetailID";//
        public static final String MODIFIER_DETAIL_NAME = "ModifierName";//
        public static final String MODIFIER_DETAIL_PRICE = "ModifierDetailPrice";//
        public static final String IS_ACTIVE = "Active";//
    }

    public static class InvoiceDetailTable {
        public static final String NAME = "tbl_InvoiceDetail";//
        public static final String INVOICE_ID = "InvoiceID";//
        public static final String INVOICE_DETAIL_ID = "InvoiceDetailID";//
        public static final String PRICELEVEL_ID = "PriceLevelID";//
        public static final String QUANTITY = "Quantity";//
        public static final String PRICE = "Price";//
        public static final String UNITPRICE = "UnitPrice";//
        public static final String PRICE_DISCOUNT = "PriceDiscount";//
        public static final String DISCOUNT_PERCENT = "DiscountPercent";//
        public static final String DISCOUNT_AMOUNT = "DiscountAmount";//
        public static final String TOTAL_AMOUNT = "TotalAmount";//
        public static final String TOTAL_VAT = "TotalVAT";//
        public static final String PRODUCT_NAME = "ProductName";//
        public static final String DISCOUNT_ON_BILL = "DiscountOnBill";//
        public static final String DISCOUNT_ON_ITEM = "DiscountOnItem";//

        public static final String GST_PERCENT = "GSTPercent";//
        public static final String GST_AMOUNT = "GSTAmount";//
        public static final String SERVICE_PERCENT = "ServicePercent";//
        public static final String SERVICE_AMOUNT = "ServiceAmount";//

    }

    public static class InvoiceDiscountTable {
        public static final String NAME = "tbl_InvoiceDiscount";//
        public static final String INVOICE_ID = "InvoiceID";//
        public static final String INVOICE_DISCOUNT_ID = "InvoiceDiscountID";//
        public static final String DISCOUNT_ID = "DiscountID";//
        public static final String NUMBER = "Number";//
        public static final String IS_PERCENT = "IsPercent";//
    }

    public static class InvoiceTable {
        public static final String NAME = "tbl_Invoice";//
        public static final String INVOICE_ID = "InvoiceID";//
        public static final String RECEIPT_NO = "ReceiptNo";//
        public static final String DATE_CREATE = "DateCreate";//
        public static final String USER_CREATE = "UserID";//
        public static final String TOTAL_VAT = "TotalVAT";//
        public static final String TOTAL_AMOUNT = "TotalAmount";//
        public static final String TOTAL_DISCOUNT = "TotalDiscount";//
        public static final String CUSTOMER_ID = "CustomerID";//
        public static final String PAYMENT_METHOD = "PaymentMethodID";//
        public static final String STORE = "StoreID";//
        public static final String IS_CHARGE = "IsCharge";//
        public static final String REFERENCE = "Reference";//
        public static final String REFUND_VALUE = "RefundValue";//
        public static final String REFUND_TYPE = "RefundType";//
        public static final String REFUND_REMARK = "RefundRemark";//
        public static final String IS_REFUND = "IsRefund";//
        public static final String TIME_REFUND = "TimeRefund";//
        public static final String CHANGE_DUE = "ChangeDue";//
        public static final String IS_ACTIVE = "IsActive";//

    }

    public static class StoreTable {
        public static final String NAME = "tbl_Store";//
        public static final String STORE_ID = "StoreID";//
        public static final String STORE_NAME = "StoreName";//
        public static final String STREET1 = "Street1";//
        public static final String STREET2 = "Street2";//
        public static final String CITY = "City";//
        public static final String COUNTRY = "Country";//

        public static final String ZIPCODE = "ZipCode";
        public static final String STATE = "State";

        public static final String PHONE2 = "Phone2";//
        public static final String PHONE1 = "Phone1";//
        public static final String EMAIL2 = "Email2";//
        public static final String EMAIL1 = "Email1";//
        public static final String OPEN_TIME = "OpenTime";//
        public static final String CLOSE_TIME = "CloseTime";//
        public static final String MORNING_TIME = "MorningTime";//
        public static final String AFTERNOON_TIME = "AfternoonTime";//
        public static final String FASTSERVICE = "FastService";//
        public static final String IS_MIN_ALLSTOCK = "IsMinAll";//
        public static final String MIN_STOCK = "MinStock";//

    }

    public static class UserTable {
        public static final String NAME = "tbl_User";//
        public static final String USER_ID = "UserID";//
        public static final String IS_ACTIVE= "IsActive";//
        public static final String USER_NAME = "UserName";//
        public static final String FULLNAME = "FullName";//
        public static final String PASSWORD = "Password";//
        public static final String EMAIL = "EMAIL";//
        public static final String ADDRESS = "Address";//
        public static final String PHONE = "Phone";//
        public static final String IMAGE = "Image";//
        public static final String STORE_ACCESS = "StoreAccess";//
        public static final String HISTORY_ACCESS = "HistoryAccess";//
        public static final String CUSTOMER_ACCESS = "CustomerAccess";//
        public static final String PRODUCT_ACCESS = "ProductAccess";//
        public static final String CATEGORY_ACCESS = "CategoryAccess";//
        public static final String DISCOUNT_ACCESS = "DiscountAccess";//
        public static final String TAX_ACCESS = "TaxAccess";//
        public static final String REPORT_ACCESS = "ReportAccess";//
        public static final String SETTING_ACCESS = "SettingAccess";//
        public static final String OPERATION_ACCESS = "OperationAccess";//


    }

    public static class ShopTable {
        public static final String NAME = "tbl_Shop";//
        public static final String SHOP_ID = "ShopID";//
        public static final String SHOP_NAME = "ShopName";//
        public static final String TAX_ID = "TaxID";//
        public static final String LOGO = "Logo";//
        public static final String WEBSITE = "WebSite";//
    }

    public static class PaymentMethodTable {
        public static final String NAME = "tbl_PaymentMethod";//
        public static final String PAYMENT_METHOD_ID = "PaymentMethodID";//
        public static final String PAYMENT_METHOD_NAME = "PaymentMethodName";//
        public static final String PAYMENT_METHOD_RESOURCE = "PaymentMethodResource";//
        public static final String IS_ACTIVE = "IsActive";//

    }

    public static class RefundTable {
        public static final String NAME = "tbl_Refund";//
        public static final String REFUND_ID = "RefundID";//
        public static final String REFUND_NAME = "RefundName";//

    }

    public static class ModifierInvoiceDetailTable {
        public static final String NAME = "tbl_ModifierInvoiceDetail";//
        public static final String MODIFIER_DETAIL_ID = "ModifierDetailID";//
        public static final String INVOICE_DETAIL_ID = "InvoiceDetailID";//
        public static final String MODIFIER_ID = "ModifierID";//
        public static final String MODIFIER_PRICE = "ModifierPrice";//

    }

    public static class PriceLevelTable {
        public static final String NAME = "tbl_PricelevelL";//
        public static final String PRICELEVEL_ID = "PriceLevelID";//
        public static final String PRODUCT_ID = "PRODUCT_ID";//
        public static final String PRICELEVEL_NAME = "Name";//
        public static final String SKU = "SKU";//
        public static final String PRICE = "Price";//
        public static final String COST = "Cost";//
        public static final String IS_ACTIVE = "IsActive";

    }

    public static class CustomerTable {
        public static final String NAME = "tbl_Customer";//
        public static final String CUSTOMER_ID = "CustomerID";//
        public static final String FULLNAME = "FullName";//
        public static final String EMAIL = "Email";//
        public static final String PHONE = "Phone";//
        public static final String FAX = "Fax";//
        public static final String ADDRESS1 = "Address1";//
        public static final String ADDRESS2 = "Address2";//
        public static final String COMPANY = "Company";//
        public static final String CITY = "City";//
        public static final String COUNTRY = "Country";//
        public static final String IS_ACTIVE = "IsActive";//
    }

    public static class OpenOperationTable {
        public static final String NAME = "tbl_OpenOperation";//
        public static final String OPEN_OPERATIONID = "OpenOperationID";//
        public static final String USERID = "UserID";//
        public static final String OPEN_TIME = "OpenTime";//
        public static final String AMOUNT = "Amount";//
    }

    public static class CloseOperationTable {
        public static final String NAME = "tbl_CloseOperation";//
        public static final String OPEN_OPERATIONID = "OpenOperationID";//
        public static final String USERID = "UserID";//
        public static final String CLOSE_OPERATIONID = "CloseOperationID";//
        public static final String CLOSE_TIME = "CloseTime";//
    }

    public static class CloseOperationDetailTable {
        public static final String NAME = "tbl_CloseOperationDetail";//
        public static final String CLOSE_OPERATION_DETAIL_ID = "CloseOperationDetailID";//
        public static final String CLOSE_OPERATIONID = "CloseOperationID";//
        public static final String PAMENT_ID = "PaymentID";//
        public static final String AMOUNT = "Amount";//
    }

    public static class TestCreate4Column {
        public static final String TABLE_NAME = "tbl_SanPham";//
        public static final String COLUMN_ID = "id";//
        public static final String COLUMN_SP1 = "sanPham1";//
        public static final String COLUMN_SP2 = "sanPham2";//
        public static final String COLUMN_SP3 = "sanPham3";//
    }

}