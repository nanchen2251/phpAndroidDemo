<?php
class Response {
	/**
	 * 按json方式输出通信数据
	 * 
	 * @param unknown $status
	 *        	状态码
	 * @param string $message
	 *        	提示信息
	 * @param array $data
	 *        	数据
	 * @return string
	 */
	public static function json($status, $message = '', $data = array()) {
		if (! is_bool ( $status )) {
			return '';
		}
		$result = array (
				'status' => $status,
				'message' => $message,
				'data' => $data 
		);
		echo json_encode ( $result,JSON_UNESCAPED_UNICODE);
	}
}