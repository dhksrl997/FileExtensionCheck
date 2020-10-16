$(function() {

	$(document).ready(function() {// 페이지 새로 고침시 유지를 위한 코드
		$.ajax({
			type : 'get',
			url : '/checkValues',
			dataType : 'json',
			success : function(data) {
				$('input[type="checkbox"]').each(function() {
					for (var i = 0; i < data.values.length; i++) {
						if ($(this).val() == data.values[i].extension) // 체크박스 value와 data val이 같으면
							$(this).prop("checked", true);	// 체크 처리
					}
				});
			}
		});
	});

	$('input[type="checkbox"]').click(function() { // 체크 , 비체크시 DB 처리
		var flag = $(this).is(":checked"); // 클릭된 체크박스의 체크여부
		if (flag) {
			$.ajax({
				type : 'get',
				url : '/'+$(this).val(),
				dataType : 'json',
				data : {
					value : $(this).val()
				}
			});
		} else {
			$.ajax({
				type : 'delete',
				url : '/'+$(this).val(),
				dataType : 'json',
				data : {
					value : $(this).val()
				}
			});
		}
	});
	
	$(".add-btn").click(function() { // 커스텀 확장자 추가
		var value=$(".input-custom").val();
		var check=/[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/;  //정규식 체크 한글포함 여부 
		
		var fixed=["bat","cmd","com","cpl","exe","scr","js"];
			if(fixed.indexOf(value)>-1){  //value가 배열안에 존재하지 않을 경우 
				alert("고정 확장자와 같은 확장자를 사용할 수 없습니다.");
				$(".input-custom").val('');
			}else if(value==""){
				alert("빈 값은 사용할 수 없습니다.");
				$(".input-custom").val('');
			}else if(check.test(value)){
				alert("확장자는 한글이 될 수 없습니다.");
				$(".input-custom").val('');
			}else{
				$.ajax({
					type : 'post',
					url : '/'+value,
					dataType : 'json',
					data : {
						value : value
					},
					success : function(data) {
						console.log("test");
						$(".amount").text(data.count);
							$(".custom-ex-list").append(`<span class="custom-ex" data-id="${data.load[0].id}">&nbsp;${data.load[0].extension}&nbsp;<i class="close-icon">X</i>&nbsp;
					&nbsp;</span>`);
							$(".input-custom").val('');
					},error : function(){
						alert("이미 존재하는 값입니다.");
					}
				});
		}
	});
	
	//X누를 때, DB에서 커스텀 확장자 삭제 처리
	$('.custom-ex-list').on('click', '.close-icon', function(e){
		var id=$(e.target).parent().data("id");
		$(e.target).parent().remove();
		$.ajax({
			type : 'delete',
			url : '/custom/'+id,
			dataType : 'json',
			data : {
				id : id
			},
			success : function(data) {
					$(".amount").text(data.count);
			}
		});
	});
	
});