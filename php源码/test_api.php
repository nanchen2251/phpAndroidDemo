<?php
require_once 'response.php';
require_once '../test01/db.php';
require_once 'connect_config.php';

$status = false;
$msg = '';
$data = array();

// $conn = Db::getInstance()->connect();
$conn = mysqli_connect(DB_HOST,DB_USER,DB_PWD,DB_NAME,DB_PORT) or die('数据库连接失败');
$query = "select * from aiya_user";
$data1 = mysqli_query($conn, $query);
if ($data1){
	$status = true;
	$msg = '成功';
	$i = 0;
	while($row = mysqli_fetch_array($data1)){
		$data [$i]['username'] = $row['username'];
		$data [$i]['password'] = $row['password'];
		$data [$i]['birthday'] = $row['birthday'];
		$i++;
	}
	echo Response::json($status,$msg,$data);
// 	echo '你好';
// 	echo '<br/>';
	// 加入JSON_UNESCAPED_UNICODE 让php转换为json的时候绕过转码为unicode
// 	echo json_encode($value,JSON_UNESCAPED_UNICODE);
// 	echo urlencode(json_encode($value));
}else{
	$status = false;
	$msg = '数据查询失败';
	$valuse = array(
			$status,
			$msg
	);
	echo json_encode($value,JSON_UNESCAPED_UNICODE);
}



