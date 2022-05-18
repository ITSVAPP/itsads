/**
 * JavaScript
 */

window.onload = function() {
	
	// 確認ボタンクリック時のイベント
	const confirmbtnEvent = () =>{
		const form = document.getElementById("form-delete");
		if(form){
			form.submit();
		}
	}	

	// 確認ボタンのイベント追加	
	const confirmbtn = document.getElementById("btn-delete");
	if(confirmbtn){
		confirmbtn.addEventListener("click",confirmbtnEvent);
	}	
}