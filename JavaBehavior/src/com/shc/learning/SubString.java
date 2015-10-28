package com.shc.learning;

public class SubString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SubString obj = new SubString();
		obj.parseXML();
	}
	
	
	private void _parseManually() {

		try {
			String _responseString = "responseDescription=\"Return Authorization ID should be 13 digits\" responseCode=\"1308\" messageOriginationTime=\"1376051435351\" transactionId=\"0/><pendingReturnStatusRes><returnAuthorizationId>1234567890</returnAuthorizationId></pendingReturnStatusRes></pendingReturnStatusResponse>";
			int _descStart = _responseString.indexOf("responseDescription=");
			int _codeStart = _responseString.indexOf("responseCode=");
			int _codeEnd = _responseString.indexOf("messageOriginationTime=");
			
			System.out.println(_descStart);
			System.out.println(_codeStart);
			System.out.println(_codeEnd);
			String _desc = _responseString.substring(_descStart+21, _codeStart-2);
			String _code = _responseString.substring(_codeStart+14, _codeEnd-2);
			System.out.println(_desc);
			System.out.println(_code);
			
		} catch (Exception e) {
			//whatever
		}
	}
	
	private void parseXML() {
		String xml = " <ffmOptionReq><orderDetail><orderNum>5279015</orderNum><source>OMS</source>";
		int startIndex = xml.indexOf("<orderNum>");
		int endIndex = xml.indexOf("</orderNum>");
		String  orderId = xml.substring(startIndex+10, endIndex);
		System.out.println(orderId);

	}
}
