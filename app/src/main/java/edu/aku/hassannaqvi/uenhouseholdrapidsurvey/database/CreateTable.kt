package edu.aku.hassannaqvi.uenhouseholdrapidsurvey.database


import edu.aku.hassannaqvi.uenhouseholdrapidsurvey.contracts.TableContracts.*


object CreateTable {


    const val SQL_CREATE_FORMS = ("CREATE TABLE "
            + FormsTable.TABLE_NAME + "("
            + FormsTable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + FormsTable.COLUMN_PROJECT_NAME + " TEXT,"
            + FormsTable.COLUMN_UID + " TEXT,"
            + FormsTable.COLUMN_PSU_CODE + " TEXT,"
            + FormsTable.COLUMN_HHID + " TEXT,"
            + FormsTable.COLUMN_SNO + " TEXT,"
            + FormsTable.COLUMN_USERNAME + " TEXT,"
            + FormsTable.COLUMN_SYSDATE + " TEXT,"
            + FormsTable.COLUMN_ISTATUS + " TEXT,"
            + FormsTable.COLUMN_DEVICEID + " TEXT,"
            + FormsTable.COLUMN_DEVICETAGID + " TEXT,"
            + FormsTable.COLUMN_ENTRY_TYPE + " TEXT,"
            + FormsTable.COLUMN_SYNCED + " TEXT,"
            + FormsTable.COLUMN_SYNCED_DATE + " TEXT,"
            + FormsTable.COLUMN_APPVERSION + " TEXT,"
            + FormsTable.COLUMN_SA1 + " TEXT"
            + " );"
            )
    const val SQL_CREATE_ENTRYLOGS = ("CREATE TABLE "
            + EntryLogTable.TABLE_NAME + "("
            + EntryLogTable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + EntryLogTable.COLUMN_PROJECT_NAME + " TEXT,"
            + EntryLogTable.COLUMN_UID + " TEXT,"
            + EntryLogTable.COLUMN_UUID + " TEXT,"
            + EntryLogTable.COLUMN_PSU_CODE + " TEXT,"
            + EntryLogTable.COLUMN_HHID + " TEXT,"
            + EntryLogTable.COLUMN_USERNAME + " TEXT,"
            + EntryLogTable.COLUMN_SYSDATE + " TEXT,"
            + EntryLogTable.COLUMN_DEVICEID + " TEXT,"
            + EntryLogTable.COLUMN_ENTRY_DATE + " TEXT,"
            + EntryLogTable.COLUMN_ISTATUS + " TEXT,"
            + EntryLogTable.COLUMN_ISTATUS96x + " TEXT,"
            + EntryLogTable.COLUMN_ENTRY_TYPE + " TEXT,"
            + EntryLogTable.COLUMN_SYNCED + " TEXT,"
            + EntryLogTable.COLUMN_SYNCED_DATE + " TEXT,"
            + EntryLogTable.COLUMN_APPVERSION + " TEXT"
            + " );"
            )


    const val SQL_CREATE_FAMILYMEMBERS = ("CREATE TABLE "
            + FamilyMembersTable.TABLE_NAME + "("
            + FamilyMembersTable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + FamilyMembersTable.COLUMN_PROJECT_NAME + " TEXT,"
            + FamilyMembersTable.COLUMN_UID + " TEXT,"
            + FamilyMembersTable.COLUMN_UUID + " TEXT,"
            + FamilyMembersTable.COLUMN_PSU_CODE + " TEXT,"
            + FamilyMembersTable.COLUMN_HHID + " TEXT,"
            + FamilyMembersTable.COLUMN_SNO + " TEXT,"
            + FamilyMembersTable.COLUMN_USERNAME + " TEXT,"
            + FamilyMembersTable.COLUMN_SYSDATE + " TEXT,"
            + FamilyMembersTable.COLUMN_INDEXED + " TEXT,"
            + FamilyMembersTable.COLUMN_ISTATUS + " TEXT,"
            + FamilyMembersTable.COLUMN_DEVICEID + " TEXT,"
            + FamilyMembersTable.COLUMN_DEVICETAGID + " TEXT,"
            + FamilyMembersTable.COLUMN_SYNCED + " TEXT,"
            + FamilyMembersTable.COLUMN_SYNCED_DATE + " TEXT,"
            + FamilyMembersTable.COLUMN_APPVERSION + " TEXT,"
            + FamilyMembersTable.COLUMN_SA2 + " TEXT"
            + " );"
            )

    /*    const val SQL_CREATE_FAMILY_MEMBERS = ("CREATE TABLE "
            + FamilyMembersTable.TABLE_NAME + "("
            + FamilyMembersTable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + FamilyMembersTable.COLUMN_PROJECT_NAME + " TEXT,"
            + FamilyMembersTable.COLUMN_UID + " TEXT,"
            + FamilyMembersTable.COLUMN_UUID + " TEXT,"
            + FamilyMembersTable.COLUMN_EB_CODE + " TEXT,"
            + FamilyMembersTable.COLUMN_HHID + " TEXT,"
            + FamilyMembersTable.COLUMN_USERNAME + " TEXT,"
            + FamilyMembersTable.COLUMN_SYSDATE + " TEXT,"
            + FamilyMembersTable.COLUMN_INDEXED + " TEXT,"
            + FamilyMembersTable.COLUMN_ISTATUS + " TEXT,"
            + FamilyMembersTable.COLUMN_DEVICEID + " TEXT,"
            + FamilyMembersTable.COLUMN_DEVICETAGID + " TEXT,"
            + FamilyMembersTable.COLUMN_SYNCED + " TEXT,"
            + FamilyMembersTable.COLUMN_SYNCED_DATE + " TEXT,"
            + FamilyMembersTable.COLUMN_APPVERSION + " TEXT,"
            + FamilyMembersTable.COLUMN_SA2 + " TEXT"
            + " );"
            )*/


    const val SQL_CREATE_MWRA = ("CREATE TABLE "
            + MwraTable.TABLE_NAME + "("
            + MwraTable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + MwraTable.COLUMN_PROJECT_NAME + " TEXT,"
            + MwraTable.COLUMN_UID + " TEXT,"
            + MwraTable.COLUMN_UUID + " TEXT,"
            + MwraTable.COLUMN_FMUID + " TEXT,"
            + MwraTable.COLUMN_SNO + " TEXT,"
            + MwraTable.COLUMN_PSU_CODE + " TEXT,"
            + MwraTable.COLUMN_HHID + " TEXT,"
            + MwraTable.COLUMN_USERNAME + " TEXT,"
            + MwraTable.COLUMN_SYSDATE + " TEXT,"
            + MwraTable.COLUMN_INDEXED + " TEXT,"
            + MwraTable.COLUMN_ISTATUS + " TEXT,"
            + MwraTable.COLUMN_DEVICEID + " TEXT,"
            + MwraTable.COLUMN_DEVICETAGID + " TEXT,"
            + MwraTable.COLUMN_SYNCED + " TEXT,"
            + MwraTable.COLUMN_SYNCED_DATE + " TEXT,"
            + MwraTable.COLUMN_APPVERSION + " TEXT,"
            + MwraTable.COLUMN_SB1 + " TEXT,"
            + MwraTable.COLUMN_SB2 + " TEXT,"
            + MwraTable.COLUMN_SB3 + " TEXT,"
            + MwraTable.COLUMN_SB41 + " TEXT,"
            + MwraTable.COLUMN_SB42 + " TEXT,"
            + MwraTable.COLUMN_SB5 + " TEXT,"
            + MwraTable.COLUMN_SB6 + " TEXT,"
            + MwraTable.COLUMN_SB7 + " TEXT"
            + " );"
            )

    const val SQL_CREATE_PREGNANCY = ("CREATE TABLE "
            + PregnancyTable.TABLE_NAME + "("
            + PregnancyTable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + PregnancyTable.COLUMN_PROJECT_NAME + " TEXT,"
            + PregnancyTable.COLUMN_UID + " TEXT,"
            + PregnancyTable.COLUMN_UUID + " TEXT,"
            + PregnancyTable.COLUMN_MUID + " TEXT,"
            + PregnancyTable.COLUMN_FMUID + " TEXT,"
            + PregnancyTable.COLUMN_PSU_CODE + " TEXT,"
            + PregnancyTable.COLUMN_SNO + " TEXT,"
            + PregnancyTable.COLUMN_M_SNO + " TEXT,"
            + PregnancyTable.COLUMN_HHID + " TEXT,"
            + PregnancyTable.COLUMN_USERNAME + " TEXT,"
            + PregnancyTable.COLUMN_SYSDATE + " TEXT,"
            + PregnancyTable.COLUMN_INDEXED + " TEXT,"
            + PregnancyTable.COLUMN_ISTATUS + " TEXT,"
            + PregnancyTable.COLUMN_DEVICEID + " TEXT,"
            + PregnancyTable.COLUMN_DEVICETAGID + " TEXT,"
            + PregnancyTable.COLUMN_SYNCED + " TEXT,"
            + PregnancyTable.COLUMN_SYNCED_DATE + " TEXT,"
            + PregnancyTable.COLUMN_APPVERSION + " TEXT,"
            + PregnancyTable.COLUMN_SB1 + " TEXT"

            + " );"
            )

    const val SQL_CREATE_CHILD = ("CREATE TABLE "
            + ChildTable.TABLE_NAME + "("
            + ChildTable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + ChildTable.COLUMN_PROJECT_NAME + " TEXT,"
            + ChildTable.COLUMN_UID + " TEXT,"
            + ChildTable.COLUMN_UUID + " TEXT,"
            + ChildTable.COLUMN_FMUID + " TEXT,"
            + ChildTable.COLUMN_MUID + " TEXT,"
            + ChildTable.COLUMN_PSU_CODE + " TEXT,"
            + ChildTable.COLUMN_HHID + " TEXT,"
            + ChildTable.COLUMN_SNO + " TEXT,"
            + ChildTable.COLUMN_USERNAME + " TEXT,"
            + ChildTable.COLUMN_SYSDATE + " TEXT,"
            + ChildTable.COLUMN_INDEXED + " TEXT,"
            + ChildTable.COLUMN_ISTATUS + " TEXT,"
            + ChildTable.COLUMN_DEVICEID + " TEXT,"
            + ChildTable.COLUMN_DEVICETAGID + " TEXT,"
            + ChildTable.COLUMN_SYNCED + " TEXT,"
            + ChildTable.COLUMN_SYNCED_DATE + " TEXT,"
            + ChildTable.COLUMN_APPVERSION + " TEXT,"
            + ChildTable.COLUMN_SC1 + " TEXT,"
            + ChildTable.COLUMN_SC2 + " TEXT,"
            + ChildTable.COLUMN_SC31 + " TEXT,"
            + ChildTable.COLUMN_SC32 + " TEXT,"
            + ChildTable.COLUMN_SC4 + " TEXT,"
            + ChildTable.COLUMN_SC5 + " TEXT"

            + " );"
            )


    const val SQL_CREATE_USERS = ("CREATE TABLE "
            + UsersTable.TABLE_NAME + "("
            + UsersTable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + UsersTable.COLUMN_USERNAME + " TEXT,"
            + UsersTable.COLUMN_PASSWORD + " TEXT,"
            + UsersTable.COLUMN_FULLNAME + " TEXT,"
            + UsersTable.COLUMN_DESIGNATION + " TEXT"
            + " );"
            )


    const val SQL_CREATE_VILLAGES = ("CREATE TABLE "
            + VillagesTable.TABLE_NAME + "("
            + VillagesTable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + VillagesTable.COLUMN_COUNTRY + " TEXT,"
            + VillagesTable.COLUMN_CCODE + " TEXT,"
            + VillagesTable.COLUMN_PROVINCE + " TEXT,"
            + VillagesTable.COLUMN_PROVCODE + " TEXT,"
            + VillagesTable.COLUMN_DISTRICT_NAME + " TEXT,"
            + VillagesTable.COLUMN_DCODE + " TEXT,"
            + VillagesTable.COLUMN_VILLAGE + " TEXT,"
            + VillagesTable.COLUMN_VCODE + " TEXT,"
            + VillagesTable.COLUMN_PSUCODE + " TEXT"
            + " );"
            )


    /*const val SQL_CREATE_RANDOM = ("CREATE TABLE "
            + RandomTable.TABLE_NAME + "("
            + RandomTable.COLUMN_ID + " INTEGER PRIMARY KEY,"
            + RandomTable.COLUMN_SNO + " TEXT,"
            + RandomTable.COLUMN_ENUM_BLOCK_CODE + " TEXT,"
            + RandomTable.COLUMN_HH_NO + " TEXT,"
            + RandomTable.COLUMN_HEAD_HH + " TEXT"
            + " );"
            )*/

    const val SQL_CREATE_VERSIONAPP = ("CREATE TABLE "
            + VersionTable.TABLE_NAME + " ("
            + VersionTable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + VersionTable.COLUMN_VERSION_CODE + " TEXT, "
            + VersionTable.COLUMN_VERSION_NAME + " TEXT, "
            + VersionTable.COLUMN_PATH_NAME + " TEXT "
            + ");"
            )


}