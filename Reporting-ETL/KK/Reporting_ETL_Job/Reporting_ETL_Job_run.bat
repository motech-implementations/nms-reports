%~d0
cd %~dp0
java -Xms256M -Xmx1024M -cp .;../lib/routines.jar;../lib/log4j-1.2.16.jar;../lib/talendcsv.jar;../lib/mysql-connector-java-3.1.14-bin.jar;../lib/talend_file_enhanced_20070724.jar;../lib/mysql-connector-java-5.1.30-bin.jar;../lib/dom4j-1.6.1.jar;reporting_etl_job_0_2.jar;health_facility_0_1.jar;subscriber_call_measure_obd_0_2.jar;campaign_0_1.jar;measure_table_execution_0_1.jar;health_block_0_1.jar;subscribers_0_2.jar;subsrciptionpack_0_1.jar;operator_dimension_0_2.jar;subscription_operator_update_0_1.jar;district_0_1.jar;health_sub_facility_0_1.jar;dimenison_table_execution_0_1.jar;village_0_1.jar;subscriber_call_measure_0_1.jar;channel_0_1.jar;time_dimension_0_1.jar;subscriptions3_0_1.jar;date_dimension_0_1.jar;log_etl_table_info_0_1.jar;taluka_0_1.jar;state_0_1.jar;campaign_schedule_0_1.jar; final_etl.reporting_etl_job_0_2.Reporting_ETL_Job --context=Default %* 