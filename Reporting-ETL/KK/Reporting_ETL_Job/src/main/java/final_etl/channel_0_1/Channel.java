// ============================================================================
//
// Copyright (c) 2006-2015, Talend Inc.
//
// This source code has been automatically generated by_Talend Open Studio for Big Data
// / Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
// http://www.apache.org/licenses/LICENSE-2.0
// 
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package final_etl.channel_0_1;

import routines.Numeric;
import routines.DataOperation;
import routines.TalendDataGenerator;
import routines.TalendString;
import routines.StringHandling;
import routines.Relational;
import routines.TalendDate;
import routines.Mathematical;
import routines.system.*;
import routines.system.api.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.Comparator;

@SuppressWarnings("unused")
/**
 * Job: Channel Purpose: channel_dimension reporting table<br>
 * Description: channel_dimension reporting table generated statically <br>
 * @author user@talend.com
 * @version 6.1.1.20151214_1327
 * @status DEV
 */
public class Channel implements TalendJob {

	public final Object obj = new Object();

	// for transmiting parameters purpose
	private Object valueObject = null;

	public Object getValueObject() {
		return this.valueObject;
	}

	public void setValueObject(Object valueObject) {
		this.valueObject = valueObject;
	}

	private final static String defaultCharset = java.nio.charset.Charset
			.defaultCharset().name();

	private final static String utf8Charset = "UTF-8";

	// create and load default properties
	private java.util.Properties defaultProps = new java.util.Properties();

	// create application properties with default
	public class ContextProperties extends java.util.Properties {

		private static final long serialVersionUID = 1L;

		public ContextProperties(java.util.Properties properties) {
			super(properties);
		}

		public ContextProperties() {
			super();
		}

		public void synchronizeContext() {

			if (report_port != null) {

				this.setProperty("report_port", report_port.toString());

			}

			if (report_server != null) {

				this.setProperty("report_server", report_server.toString());

			}

			if (report_database != null) {

				this.setProperty("report_database", report_database.toString());

			}

			if (report_login != null) {

				this.setProperty("report_login", report_login.toString());

			}

			if (report_password != null) {

				this.setProperty("report_password", report_password.toString());

			}

			if (report_AdditionalParams != null) {

				this.setProperty("report_AdditionalParams",
						report_AdditionalParams.toString());

			}

		}

		public String report_port;

		public String getReport_port() {
			return this.report_port;
		}

		public String report_server;

		public String getReport_server() {
			return this.report_server;
		}

		public String report_database;

		public String getReport_database() {
			return this.report_database;
		}

		public String report_login;

		public String getReport_login() {
			return this.report_login;
		}

		public java.lang.String report_password;

		public java.lang.String getReport_password() {
			return this.report_password;
		}

		public String report_AdditionalParams;

		public String getReport_AdditionalParams() {
			return this.report_AdditionalParams;
		}
	}

	private ContextProperties context = new ContextProperties();

	public ContextProperties getContext() {
		return this.context;
	}

	private final String jobVersion = "0.1";
	private final String jobName = "Channel";
	private final String projectName = "FINAL_ETL";
	public Integer errorCode = null;
	private String currentComponent = "";

	private final java.util.Map<String, Object> globalMap = new java.util.HashMap<String, Object>();
	private final static java.util.Map<String, Object> junitGlobalMap = new java.util.HashMap<String, Object>();

	private final java.util.Map<String, Long> start_Hash = new java.util.HashMap<String, Long>();
	private final java.util.Map<String, Long> end_Hash = new java.util.HashMap<String, Long>();
	private final java.util.Map<String, Boolean> ok_Hash = new java.util.HashMap<String, Boolean>();
	public final java.util.List<String[]> globalBuffer = new java.util.ArrayList<String[]>();

	// OSGi DataSource
	private final static String KEY_DB_DATASOURCES = "KEY_DB_DATASOURCES";

	public void setDataSources(
			java.util.Map<String, javax.sql.DataSource> dataSources) {
		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		for (java.util.Map.Entry<String, javax.sql.DataSource> dataSourceEntry : dataSources
				.entrySet()) {
			talendDataSources.put(
					dataSourceEntry.getKey(),
					new routines.system.TalendDataSource(dataSourceEntry
							.getValue()));
		}
		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
	}

	private final java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
	private final java.io.PrintStream errorMessagePS = new java.io.PrintStream(
			new java.io.BufferedOutputStream(baos));

	public String getExceptionStackTrace() {
		if ("failure".equals(this.getStatus())) {
			errorMessagePS.flush();
			return baos.toString();
		}
		return null;
	}

	private Exception exception;

	public Exception getException() {
		if ("failure".equals(this.getStatus())) {
			return this.exception;
		}
		return null;
	}

	private class TalendException extends Exception {

		private static final long serialVersionUID = 1L;

		private java.util.Map<String, Object> globalMap = null;
		private Exception e = null;
		private String currentComponent = null;
		private String virtualComponentName = null;

		public void setVirtualComponentName(String virtualComponentName) {
			this.virtualComponentName = virtualComponentName;
		}

		private TalendException(Exception e, String errorComponent,
				final java.util.Map<String, Object> globalMap) {
			this.currentComponent = errorComponent;
			this.globalMap = globalMap;
			this.e = e;
		}

		public Exception getException() {
			return this.e;
		}

		public String getCurrentComponent() {
			return this.currentComponent;
		}

		public String getExceptionCauseMessage(Exception e) {
			Throwable cause = e;
			String message = null;
			int i = 10;
			while (null != cause && 0 < i--) {
				message = cause.getMessage();
				if (null == message) {
					cause = cause.getCause();
				} else {
					break;
				}
			}
			if (null == message) {
				message = e.getClass().getName();
			}
			return message;
		}

		@Override
		public void printStackTrace() {
			if (!(e instanceof TalendException || e instanceof TDieException)) {
				if (virtualComponentName != null
						&& currentComponent.indexOf(virtualComponentName + "_") == 0) {
					globalMap.put(virtualComponentName + "_ERROR_MESSAGE",
							getExceptionCauseMessage(e));
				}
				globalMap.put(currentComponent + "_ERROR_MESSAGE",
						getExceptionCauseMessage(e));
				System.err
						.println("Exception in component " + currentComponent);
			}
			if (!(e instanceof TDieException)) {
				if (e instanceof TalendException) {
					e.printStackTrace();
				} else {
					e.printStackTrace();
					e.printStackTrace(errorMessagePS);
					Channel.this.exception = e;
				}
			}
			if (!(e instanceof TalendException)) {
				try {
					for (java.lang.reflect.Method m : this.getClass()
							.getEnclosingClass().getMethods()) {
						if (m.getName().compareTo(currentComponent + "_error") == 0) {
							m.invoke(Channel.this, new Object[] { e,
									currentComponent, globalMap });
							break;
						}
					}

					if (!(e instanceof TDieException)) {
					}
				} catch (Exception e) {
					this.e.printStackTrace();
				}
			}
		}
	}

	public void tFileInputDelimited_1_error(Exception exception,
			String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputDelimited_1_onSubJobError(exception, errorComponent,
				globalMap);
	}

	public void tContextLoad_1_error(Exception exception,
			String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputDelimited_1_onSubJobError(exception, errorComponent,
				globalMap);
	}

	public void tMysqlRow_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tMysqlRow_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tFileInputDelimited_1_onSubJobError(Exception exception,
			String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread
				.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(),
				ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tMysqlRow_1_onSubJobError(Exception exception,
			String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread
				.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(),
				ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public static class row3Struct implements
			routines.system.IPersistableRow<row3Struct> {
		final static byte[] commonByteArrayLock_FINAL_ETL_Channel = new byte[0];
		static byte[] commonByteArray_FINAL_ETL_Channel = new byte[0];

		public String key;

		public String getKey() {
			return this.key;
		}

		public String value;

		public String getValue() {
			return this.value;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_FINAL_ETL_Channel.length) {
					if (length < 1024
							&& commonByteArray_FINAL_ETL_Channel.length == 0) {
						commonByteArray_FINAL_ETL_Channel = new byte[1024];
					} else {
						commonByteArray_FINAL_ETL_Channel = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_FINAL_ETL_Channel, 0, length);
				strReturn = new String(commonByteArray_FINAL_ETL_Channel, 0,
						length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos)
				throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_FINAL_ETL_Channel) {

				try {

					int length = 0;

					this.key = readString(dis);

					this.value = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.key, dos);

				// String

				writeString(this.value, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("key=" + key);
			sb.append(",value=" + value);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row3Struct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(),
						object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public void tFileInputDelimited_1Process(
			final java.util.Map<String, Object> globalMap)
			throws TalendException {
		globalMap.put("tFileInputDelimited_1_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		String iterateId = "";

		String currentComponent = "";
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {

			String currentMethodName = new java.lang.Exception()
					.getStackTrace()[0].getMethodName();
			boolean resumeIt = currentMethodName.equals(resumeEntryMethodName);
			if (resumeEntryMethodName == null || resumeIt || globalResumeTicket) {// start
																					// the
																					// resume
				globalResumeTicket = true;

				row3Struct row3 = new row3Struct();

				/**
				 * [tContextLoad_1 begin ] start
				 */

				ok_Hash.put("tContextLoad_1", false);
				start_Hash.put("tContextLoad_1", System.currentTimeMillis());

				currentComponent = "tContextLoad_1";

				int tos_count_tContextLoad_1 = 0;

				java.util.List<String> assignList_tContextLoad_1 = new java.util.ArrayList<String>();
				java.util.List<String> newPropertyList_tContextLoad_1 = new java.util.ArrayList<String>();
				java.util.List<String> noAssignList_tContextLoad_1 = new java.util.ArrayList<String>();
				int nb_line_tContextLoad_1 = 0;

				/**
				 * [tContextLoad_1 begin ] stop
				 */

				/**
				 * [tFileInputDelimited_1 begin ] start
				 */

				ok_Hash.put("tFileInputDelimited_1", false);
				start_Hash.put("tFileInputDelimited_1",
						System.currentTimeMillis());

				currentComponent = "tFileInputDelimited_1";

				int tos_count_tFileInputDelimited_1 = 0;

				final routines.system.RowState rowstate_tFileInputDelimited_1 = new routines.system.RowState();

				int nb_line_tFileInputDelimited_1 = 0;
				org.talend.fileprocess.FileInputDelimited fid_tFileInputDelimited_1 = null;
				try {

					Object filename_tFileInputDelimited_1 = "../db_connection.txt";
					if (filename_tFileInputDelimited_1 instanceof java.io.InputStream) {

						int footer_value_tFileInputDelimited_1 = 0, random_value_tFileInputDelimited_1 = -1;
						if (footer_value_tFileInputDelimited_1 > 0
								|| random_value_tFileInputDelimited_1 > 0) {
							throw new java.lang.Exception(
									"When the input source is a stream,footer and random shouldn't be bigger than 0.");
						}

					}
					try {
						fid_tFileInputDelimited_1 = new org.talend.fileprocess.FileInputDelimited(
								"../db_connection.txt", "ISO-8859-15", ";",
								"\n", true, 0, 0, -1, -1, false);
					} catch (java.lang.Exception e) {

						System.err.println(e.getMessage());

					}

					while (fid_tFileInputDelimited_1 != null
							&& fid_tFileInputDelimited_1.nextRecord()) {
						rowstate_tFileInputDelimited_1.reset();

						row3 = null;

						boolean whetherReject_tFileInputDelimited_1 = false;
						row3 = new row3Struct();
						try {

							int columnIndexWithD_tFileInputDelimited_1 = 0;

							columnIndexWithD_tFileInputDelimited_1 = 0;

							row3.key = fid_tFileInputDelimited_1
									.get(columnIndexWithD_tFileInputDelimited_1);

							columnIndexWithD_tFileInputDelimited_1 = 1;

							row3.value = fid_tFileInputDelimited_1
									.get(columnIndexWithD_tFileInputDelimited_1);

							if (rowstate_tFileInputDelimited_1.getException() != null) {
								throw rowstate_tFileInputDelimited_1
										.getException();
							}

						} catch (java.lang.Exception e) {
							whetherReject_tFileInputDelimited_1 = true;

							System.err.println(e.getMessage());
							row3 = null;

						}

						/**
						 * [tFileInputDelimited_1 begin ] stop
						 */

						/**
						 * [tFileInputDelimited_1 main ] start
						 */

						currentComponent = "tFileInputDelimited_1";

						tos_count_tFileInputDelimited_1++;

						/**
						 * [tFileInputDelimited_1 main ] stop
						 */
						// Start of branch "row3"
						if (row3 != null) {

							/**
							 * [tContextLoad_1 main ] start
							 */

							currentComponent = "tContextLoad_1";

							// ////////////////////////
							String tmp_key_tContextLoad_1 = null;
							String key_tContextLoad_1 = null;
							if (row3.key != null) {
								tmp_key_tContextLoad_1 = row3.key.trim();
								if ((tmp_key_tContextLoad_1.startsWith("#") || tmp_key_tContextLoad_1
										.startsWith("!"))) {
									tmp_key_tContextLoad_1 = null;
								} else {
									row3.key = tmp_key_tContextLoad_1;
								}
							}
							if (row3.key != null) {
								key_tContextLoad_1 = row3.key;
							}
							String value_tContextLoad_1 = null;
							if (row3.value != null) {
								value_tContextLoad_1 = row3.value;
							}

							if (tmp_key_tContextLoad_1 != null) {
								try {
									if (key_tContextLoad_1 != null
											&& "report_port"
													.equals(key_tContextLoad_1)) {
										context.report_port = value_tContextLoad_1;
									}

									if (key_tContextLoad_1 != null
											&& "report_server"
													.equals(key_tContextLoad_1)) {
										context.report_server = value_tContextLoad_1;
									}

									if (key_tContextLoad_1 != null
											&& "report_database"
													.equals(key_tContextLoad_1)) {
										context.report_database = value_tContextLoad_1;
									}

									if (key_tContextLoad_1 != null
											&& "report_login"
													.equals(key_tContextLoad_1)) {
										context.report_login = value_tContextLoad_1;
									}

									if (key_tContextLoad_1 != null
											&& "report_password"
													.equals(key_tContextLoad_1)) {
										context.report_password = value_tContextLoad_1;
									}

									if (key_tContextLoad_1 != null
											&& "report_AdditionalParams"
													.equals(key_tContextLoad_1)) {
										context.report_AdditionalParams = value_tContextLoad_1;
									}

									if (context.getProperty(key_tContextLoad_1) != null) {
										assignList_tContextLoad_1
												.add(key_tContextLoad_1);
									} else {
										newPropertyList_tContextLoad_1
												.add(key_tContextLoad_1);
									}
									if (value_tContextLoad_1 == null) {
										context.setProperty(key_tContextLoad_1,
												"");
									} else {
										context.setProperty(key_tContextLoad_1,
												value_tContextLoad_1);
									}
								} catch (java.lang.Exception e) {
									System.err
											.println("Setting a value for the key \""
													+ key_tContextLoad_1
													+ "\" has failed. Error message: "
													+ e.getMessage());
								}
								nb_line_tContextLoad_1++;
							}
							// ////////////////////////

							tos_count_tContextLoad_1++;

							/**
							 * [tContextLoad_1 main ] stop
							 */

						} // End of branch "row3"

						/**
						 * [tFileInputDelimited_1 end ] start
						 */

						currentComponent = "tFileInputDelimited_1";

					}
				} finally {
					if (!((Object) ("../db_connection.txt") instanceof java.io.InputStream)) {
						if (fid_tFileInputDelimited_1 != null) {
							fid_tFileInputDelimited_1.close();
						}
					}
					if (fid_tFileInputDelimited_1 != null) {
						globalMap.put("tFileInputDelimited_1_NB_LINE",
								fid_tFileInputDelimited_1.getRowNumber());

					}
				}

				ok_Hash.put("tFileInputDelimited_1", true);
				end_Hash.put("tFileInputDelimited_1",
						System.currentTimeMillis());

				/**
				 * [tFileInputDelimited_1 end ] stop
				 */

				/**
				 * [tContextLoad_1 end ] start
				 */

				currentComponent = "tContextLoad_1";

				java.util.Enumeration<?> enu_tContextLoad_1 = context
						.propertyNames();
				while (enu_tContextLoad_1.hasMoreElements()) {
					String key_tContextLoad_1 = (String) enu_tContextLoad_1
							.nextElement();
					if (!assignList_tContextLoad_1.contains(key_tContextLoad_1)
							&& !newPropertyList_tContextLoad_1
									.contains(key_tContextLoad_1)) {
						noAssignList_tContextLoad_1.add(key_tContextLoad_1);
					}
				}

				String newPropertyStr_tContextLoad_1 = newPropertyList_tContextLoad_1
						.toString();
				String newProperty_tContextLoad_1 = newPropertyStr_tContextLoad_1
						.substring(1,
								newPropertyStr_tContextLoad_1.length() - 1);

				String noAssignStr_tContextLoad_1 = noAssignList_tContextLoad_1
						.toString();
				String noAssign_tContextLoad_1 = noAssignStr_tContextLoad_1
						.substring(1, noAssignStr_tContextLoad_1.length() - 1);

				globalMap.put("tContextLoad_1_KEY_NOT_INCONTEXT",
						newProperty_tContextLoad_1);
				globalMap.put("tContextLoad_1_KEY_NOT_LOADED",
						noAssign_tContextLoad_1);

				globalMap.put("tContextLoad_1_NB_LINE", nb_line_tContextLoad_1);

				List<String> parametersToEncrypt_tContextLoad_1 = new java.util.ArrayList<String>();

				parametersToEncrypt_tContextLoad_1.add("report_password");

				resumeUtil.addLog("NODE", "NODE:tContextLoad_1", "", Thread
						.currentThread().getId() + "", "", "", "", "",
						resumeUtil.convertToJsonText(context,
								parametersToEncrypt_tContextLoad_1));

				ok_Hash.put("tContextLoad_1", true);
				end_Hash.put("tContextLoad_1", System.currentTimeMillis());

				/**
				 * [tContextLoad_1 end ] stop
				 */

			}// end the resume

			if (resumeEntryMethodName == null || globalResumeTicket) {
				resumeUtil
						.addLog("CHECKPOINT",
								"CONNECTION:SUBJOB_OK:tFileInputDelimited_1:OnSubjobOk",
								"", Thread.currentThread().getId() + "", "",
								"", "", "", "");
			}

			tMysqlRow_1Process(globalMap);

		} catch (java.lang.Exception e) {

			TalendException te = new TalendException(e, currentComponent,
					globalMap);

			throw te;
		} catch (java.lang.Error error) {

			throw error;
		} finally {

			try {

				/**
				 * [tFileInputDelimited_1 finally ] start
				 */

				currentComponent = "tFileInputDelimited_1";

				/**
				 * [tFileInputDelimited_1 finally ] stop
				 */

				/**
				 * [tContextLoad_1 finally ] start
				 */

				currentComponent = "tContextLoad_1";

				/**
				 * [tContextLoad_1 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tFileInputDelimited_1_SUBPROCESS_STATE", 1);
	}

	public void tMysqlRow_1Process(final java.util.Map<String, Object> globalMap)
			throws TalendException {
		globalMap.put("tMysqlRow_1_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		String iterateId = "";

		String currentComponent = "";
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {

			String currentMethodName = new java.lang.Exception()
					.getStackTrace()[0].getMethodName();
			boolean resumeIt = currentMethodName.equals(resumeEntryMethodName);
			if (resumeEntryMethodName == null || resumeIt || globalResumeTicket) {// start
																					// the
																					// resume
				globalResumeTicket = true;

				/**
				 * [tMysqlRow_1 begin ] start
				 */

				ok_Hash.put("tMysqlRow_1", false);
				start_Hash.put("tMysqlRow_1", System.currentTimeMillis());

				currentComponent = "tMysqlRow_1";

				int tos_count_tMysqlRow_1 = 0;

				java.sql.Connection conn_tMysqlRow_1 = null;
				String query_tMysqlRow_1 = "";
				boolean whetherReject_tMysqlRow_1 = false;
				String driverClass_tMysqlRow_1 = "org.gjt.mm.mysql.Driver";
				java.lang.Class.forName(driverClass_tMysqlRow_1);

				String url_tMysqlRow_1 = "jdbc:mysql://"
						+ context.report_server + ":" + context.report_port
						+ "/" + context.report_database + "?"
						+ context.report_AdditionalParams;
				String dbUser_tMysqlRow_1 = context.report_login;

				final String decryptedPassword_tMysqlRow_1 = context.report_password;

				String dbPwd_tMysqlRow_1 = decryptedPassword_tMysqlRow_1;

				conn_tMysqlRow_1 = java.sql.DriverManager.getConnection(
						url_tMysqlRow_1, dbUser_tMysqlRow_1, dbPwd_tMysqlRow_1);

				if (conn_tMysqlRow_1.getAutoCommit()) {

					conn_tMysqlRow_1.setAutoCommit(false);

				}
				int commitEvery_tMysqlRow_1 = 10000;
				int commitCounter_tMysqlRow_1 = 0;

				java.sql.Statement stmt_tMysqlRow_1 = conn_tMysqlRow_1
						.createStatement();

				/**
				 * [tMysqlRow_1 begin ] stop
				 */

				/**
				 * [tMysqlRow_1 main ] start
				 */

				currentComponent = "tMysqlRow_1";

				query_tMysqlRow_1 = "INSERT INTO channel_dimension(ID, Channel) \nVALUES (1, 'MCTS_IMPORT'),(2, 'IVR') ON DUPLICATE KEY \nUPDATE Channel = VALUES(Channel)";
				whetherReject_tMysqlRow_1 = false;
				globalMap.put("tMysqlRow_1_QUERY", query_tMysqlRow_1);
				try {
					stmt_tMysqlRow_1.execute(query_tMysqlRow_1);

				} catch (java.lang.Exception e) {
					whetherReject_tMysqlRow_1 = true;

					System.err.print(e.getMessage());

				}

				commitCounter_tMysqlRow_1++;
				if (commitEvery_tMysqlRow_1 <= commitCounter_tMysqlRow_1) {

					conn_tMysqlRow_1.commit();

					commitCounter_tMysqlRow_1 = 0;
				}

				tos_count_tMysqlRow_1++;

				/**
				 * [tMysqlRow_1 main ] stop
				 */

				/**
				 * [tMysqlRow_1 end ] start
				 */

				currentComponent = "tMysqlRow_1";

				stmt_tMysqlRow_1.close();
				if (commitEvery_tMysqlRow_1 > commitCounter_tMysqlRow_1) {

					conn_tMysqlRow_1.commit();

					commitCounter_tMysqlRow_1 = 0;

				}
				conn_tMysqlRow_1.close();

				ok_Hash.put("tMysqlRow_1", true);
				end_Hash.put("tMysqlRow_1", System.currentTimeMillis());

				/**
				 * [tMysqlRow_1 end ] stop
				 */
			}// end the resume

		} catch (java.lang.Exception e) {

			TalendException te = new TalendException(e, currentComponent,
					globalMap);

			throw te;
		} catch (java.lang.Error error) {

			throw error;
		} finally {

			try {

				/**
				 * [tMysqlRow_1 finally ] start
				 */

				currentComponent = "tMysqlRow_1";

				/**
				 * [tMysqlRow_1 finally ] stop
				 */
			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tMysqlRow_1_SUBPROCESS_STATE", 1);
	}

	public String resuming_logs_dir_path = null;
	public String resuming_checkpoint_path = null;
	public String parent_part_launcher = null;
	private String resumeEntryMethodName = null;
	private boolean globalResumeTicket = false;

	public boolean watch = false;
	// portStats is null, it means don't execute the statistics
	public Integer portStats = null;
	public int portTraces = 4334;
	public String clientHost;
	public String defaultClientHost = "localhost";
	public String contextStr = "Default";
	public boolean isDefaultContext = true;
	public String pid = "0";
	public String rootPid = null;
	public String fatherPid = null;
	public String fatherNode = null;
	public long startTime = 0;
	public boolean isChildJob = false;
	public String log4jLevel = "";

	private boolean execStat = true;

	private ThreadLocal<java.util.Map<String, String>> threadLocal = new ThreadLocal<java.util.Map<String, String>>() {
		protected java.util.Map<String, String> initialValue() {
			java.util.Map<String, String> threadRunResultMap = new java.util.HashMap<String, String>();
			threadRunResultMap.put("errorCode", null);
			threadRunResultMap.put("status", "");
			return threadRunResultMap;
		};
	};

	private java.util.Properties context_param = new java.util.Properties();
	public java.util.Map<String, Object> parentContextMap = new java.util.HashMap<String, Object>();

	public String status = "";

	public static void main(String[] args) {
		final Channel ChannelClass = new Channel();

		int exitCode = ChannelClass.runJobInTOS(args);

		System.exit(exitCode);
	}

	public String[][] runJob(String[] args) {

		int exitCode = runJobInTOS(args);
		String[][] bufferValue = new String[][] { { Integer.toString(exitCode) } };

		return bufferValue;
	}

	public boolean hastBufferOutputComponent() {
		boolean hastBufferOutput = false;

		return hastBufferOutput;
	}

	public int runJobInTOS(String[] args) {
		// reset status
		status = "";

		String lastStr = "";
		for (String arg : args) {
			if (arg.equalsIgnoreCase("--context_param")) {
				lastStr = arg;
			} else if (lastStr.equals("")) {
				evalParam(arg);
			} else {
				evalParam(lastStr + " " + arg);
				lastStr = "";
			}
		}

		if (clientHost == null) {
			clientHost = defaultClientHost;
		}

		if (pid == null || "0".equals(pid)) {
			pid = TalendString.getAsciiRandomString(6);
		}

		if (rootPid == null) {
			rootPid = pid;
		}
		if (fatherPid == null) {
			fatherPid = pid;
		} else {
			isChildJob = true;
		}

		try {
			// call job/subjob with an existing context, like:
			// --context=production. if without this parameter, there will use
			// the default context instead.
			java.io.InputStream inContext = Channel.class.getClassLoader()
					.getResourceAsStream(
							"final_etl/channel_0_1/contexts/" + contextStr
									+ ".properties");
			if (isDefaultContext && inContext == null) {

			} else {
				if (inContext != null) {
					// defaultProps is in order to keep the original context
					// value
					defaultProps.load(inContext);
					inContext.close();
					context = new ContextProperties(defaultProps);
				} else {
					// print info and job continue to run, for case:
					// context_param is not empty.
					System.err.println("Could not find the context "
							+ contextStr);
				}
			}

			if (!context_param.isEmpty()) {
				context.putAll(context_param);
			}
			context.report_port = (String) context.getProperty("report_port");
			context.report_server = (String) context
					.getProperty("report_server");
			context.report_database = (String) context
					.getProperty("report_database");
			context.report_login = (String) context.getProperty("report_login");
			String pwd_report_password_value = context
					.getProperty("report_password");
			context.report_password = null;
			if (pwd_report_password_value != null) {
				if (context_param.containsKey("report_password")) {// no need to
																	// decrypt
																	// if it
																	// come from
																	// program
																	// argument
																	// or parent
																	// job
																	// runtime
					context.report_password = pwd_report_password_value;
				} else if (!pwd_report_password_value.isEmpty()) {
					try {
						context.report_password = routines.system.PasswordEncryptUtil
								.decryptPassword(pwd_report_password_value);
						context.put("report_password", context.report_password);
					} catch (java.lang.RuntimeException e) {
						// do nothing
					}
				}
			}
			context.report_AdditionalParams = (String) context
					.getProperty("report_AdditionalParams");
		} catch (java.io.IOException ie) {
			System.err.println("Could not load context " + contextStr);
			ie.printStackTrace();
		}

		// get context value from parent directly
		if (parentContextMap != null && !parentContextMap.isEmpty()) {
			if (parentContextMap.containsKey("report_port")) {
				context.report_port = (String) parentContextMap
						.get("report_port");
			}
			if (parentContextMap.containsKey("report_server")) {
				context.report_server = (String) parentContextMap
						.get("report_server");
			}
			if (parentContextMap.containsKey("report_database")) {
				context.report_database = (String) parentContextMap
						.get("report_database");
			}
			if (parentContextMap.containsKey("report_login")) {
				context.report_login = (String) parentContextMap
						.get("report_login");
			}
			if (parentContextMap.containsKey("report_password")) {
				context.report_password = (java.lang.String) parentContextMap
						.get("report_password");
			}
			if (parentContextMap.containsKey("report_AdditionalParams")) {
				context.report_AdditionalParams = (String) parentContextMap
						.get("report_AdditionalParams");
			}
		}

		// Resume: init the resumeUtil
		resumeEntryMethodName = ResumeUtil
				.getResumeEntryMethodName(resuming_checkpoint_path);
		resumeUtil = new ResumeUtil(resuming_logs_dir_path, isChildJob, rootPid);
		resumeUtil.initCommonInfo(pid, rootPid, fatherPid, projectName,
				jobName, contextStr, jobVersion);

		List<String> parametersToEncrypt = new java.util.ArrayList<String>();
		parametersToEncrypt.add("report_password");
		// Resume: jobStart
		resumeUtil.addLog("JOB_STARTED", "JOB:" + jobName,
				parent_part_launcher, Thread.currentThread().getId() + "", "",
				"", "", "",
				resumeUtil.convertToJsonText(context, parametersToEncrypt));

		java.util.concurrent.ConcurrentHashMap<Object, Object> concurrentHashMap = new java.util.concurrent.ConcurrentHashMap<Object, Object>();
		globalMap.put("concurrentHashMap", concurrentHashMap);

		long startUsedMemory = Runtime.getRuntime().totalMemory()
				- Runtime.getRuntime().freeMemory();
		long endUsedMemory = 0;
		long end = 0;

		startTime = System.currentTimeMillis();

		this.globalResumeTicket = true;// to run tPreJob

		this.globalResumeTicket = false;// to run others jobs

		try {
			errorCode = null;
			tFileInputDelimited_1Process(globalMap);
			if (!"failure".equals(status)) {
				status = "end";
			}
		} catch (TalendException e_tFileInputDelimited_1) {
			globalMap.put("tFileInputDelimited_1_SUBPROCESS_STATE", -1);

			e_tFileInputDelimited_1.printStackTrace();

		}

		this.globalResumeTicket = true;// to run tPostJob

		end = System.currentTimeMillis();

		if (watch) {
			System.out.println((end - startTime) + " milliseconds");
		}

		endUsedMemory = Runtime.getRuntime().totalMemory()
				- Runtime.getRuntime().freeMemory();
		if (false) {
			System.out.println((endUsedMemory - startUsedMemory)
					+ " bytes memory increase when running : Channel");
		}

		int returnCode = 0;
		if (errorCode == null) {
			returnCode = status != null && status.equals("failure") ? 1 : 0;
		} else {
			returnCode = errorCode.intValue();
		}
		resumeUtil.addLog("JOB_ENDED", "JOB:" + jobName, parent_part_launcher,
				Thread.currentThread().getId() + "", "", "" + returnCode, "",
				"", "");

		return returnCode;

	}

	// only for OSGi env
	public void destroy() {

	}

	private java.util.Map<String, Object> getSharedConnections4REST() {
		java.util.Map<String, Object> connections = new java.util.HashMap<String, Object>();

		return connections;
	}

	private void evalParam(String arg) {
		if (arg.startsWith("--resuming_logs_dir_path")) {
			resuming_logs_dir_path = arg.substring(25);
		} else if (arg.startsWith("--resuming_checkpoint_path")) {
			resuming_checkpoint_path = arg.substring(27);
		} else if (arg.startsWith("--parent_part_launcher")) {
			parent_part_launcher = arg.substring(23);
		} else if (arg.startsWith("--watch")) {
			watch = true;
		} else if (arg.startsWith("--stat_port=")) {
			String portStatsStr = arg.substring(12);
			if (portStatsStr != null && !portStatsStr.equals("null")) {
				portStats = Integer.parseInt(portStatsStr);
			}
		} else if (arg.startsWith("--trace_port=")) {
			portTraces = Integer.parseInt(arg.substring(13));
		} else if (arg.startsWith("--client_host=")) {
			clientHost = arg.substring(14);
		} else if (arg.startsWith("--context=")) {
			contextStr = arg.substring(10);
			isDefaultContext = false;
		} else if (arg.startsWith("--father_pid=")) {
			fatherPid = arg.substring(13);
		} else if (arg.startsWith("--root_pid=")) {
			rootPid = arg.substring(11);
		} else if (arg.startsWith("--father_node=")) {
			fatherNode = arg.substring(14);
		} else if (arg.startsWith("--pid=")) {
			pid = arg.substring(6);
		} else if (arg.startsWith("--context_param")) {
			String keyValue = arg.substring(16);
			int index = -1;
			if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
				if (fatherPid == null) {
					context_param.put(keyValue.substring(0, index),
							replaceEscapeChars(keyValue.substring(index + 1)));
				} else { // the subjob won't escape the especial chars
					context_param.put(keyValue.substring(0, index),
							keyValue.substring(index + 1));
				}
			}
		} else if (arg.startsWith("--log4jLevel=")) {
			log4jLevel = arg.substring(13);
		}

	}

	private final String[][] escapeChars = { { "\\\\", "\\" }, { "\\n", "\n" },
			{ "\\'", "\'" }, { "\\r", "\r" }, { "\\f", "\f" }, { "\\b", "\b" },
			{ "\\t", "\t" } };

	private String replaceEscapeChars(String keyValue) {

		if (keyValue == null || ("").equals(keyValue.trim())) {
			return keyValue;
		}

		StringBuilder result = new StringBuilder();
		int currIndex = 0;
		while (currIndex < keyValue.length()) {
			int index = -1;
			// judege if the left string includes escape chars
			for (String[] strArray : escapeChars) {
				index = keyValue.indexOf(strArray[0], currIndex);
				if (index >= 0) {

					result.append(keyValue.substring(currIndex,
							index + strArray[0].length()).replace(strArray[0],
							strArray[1]));
					currIndex = index + strArray[0].length();
					break;
				}
			}
			// if the left string doesn't include escape chars, append the left
			// into the result
			if (index < 0) {
				result.append(keyValue.substring(currIndex));
				currIndex = currIndex + keyValue.length();
			}
		}

		return result.toString();
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public String getStatus() {
		return status;
	}

	ResumeUtil resumeUtil = null;
}
/************************************************************************************************
 * 39670 characters generated by Talend Open Studio for Big Data on the May 20,
 * 2016 2:50:03 PM PDT
 ************************************************************************************************/
