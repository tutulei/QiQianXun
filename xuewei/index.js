$(document).ready(function() {
			$('.w3_play_icon,.w3_play_icon1,.w3_play_icon2').magnificPopup({
				type: 'inline',
				fixedContentPos: false,
				fixedBgPos: true,
				overflowY: 'auto',
				closeBtnInside: true,
				preloader: false,
				midClick: true,
				removalDelay: 300,
				mainClass: 'my-mfp-zoom-in',
			});
		}
		$('#login').click(function() {
				$.ajax({
					type: 'POST',
					url: "http://101.132.157.72:8086/login",
					data: {
						"uid": $("#uid").val(),
						"Password": $("#Password").val()
						// csrfmiddlewaretoken: '{{ csrf_token }}'
					},
					success: function(msg) { // 返回的RequestResult的json对象
						alert("hello2")
						var url = "";
						if (msg > 0) {
							if (msg === 1) {
								url = "www.baidu.com";
							}
							setTimeout(function() {
								window.location.href = url;
							}, 2000);
						} else {
							window.confirm("账号或密码错误");
						}
					},
					dataType: 'jsonp'
				});

			};
