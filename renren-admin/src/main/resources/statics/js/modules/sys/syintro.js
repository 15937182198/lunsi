$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/syintro/list',
        datatype: "json",
        colModel: [
			{ label: 'introid', name: 'introid', index: 'introId', width: 50, key: true },
			{ label: '论思简介内容', name: 'introcontent', index: 'introContent', width: 80 },
			{ label: '论思简介图片', name: 'imgaddress', index: 'imgAddress', width: 80 , formatter: function (cellvalue, options, rowObject) {
                    var data=rowObject.imgaddress;
                    return '<img src="'+data+ '"  style="width:50px;height:50px;" />';
                }},
			{ label: '添加时间', name: 'addtime', index: 'addTime', width: 80 }, 			
			{ label: '修改时间', name: 'updatetime', index: 'updateTime', width: 80 }			
        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"page", 
            rows:"limit", 
            order: "order"
        },
        gridComplete:function(){
        	//隐藏grid底部滚动条
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }
    });
});

var vm = new Vue({
	el:'#rrapp',
	data:{
		showList: true,
		title: null,
		syintro: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.syintro = {};
            var imgaddress = vm.syintro.imgaddress;
            var introcontent = vm.syintro.introcontent;
            $("#demo1").attr("src",imgaddress);
            $("#demo1").val(null);
            $("#introcontent").val(null);
		},
		update: function (event) {
			var introid = getSelectedRow();
			if(introid == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(introid);
		},
		saveOrUpdate: function (event) {
            var formdata=new FormData();
            $('#btnSaveOrUpdate').button('loading').delay(1000).queue(function() {
                var url = vm.syintro.introid == null ? "sys/syintro/save" : "sys/syintro/update";
                var url1 ="/renren-admin/sys/syintro/syIntroFileUpload";
                var rul2="/renren-admin/sys/syintro/syIntroFileDelete";
                formdata.append('file', $('#file')[0].files[0]);

                $.ajax({
                    url : url1,//这里写你的url
                    type : 'POST',
                    data:formdata,
                    contentType: false,// 当有文件要上传时，此项是必须的，否则后台无法识别文件流的起始位置
                    processData: false,// 是否序列化data属性，默认true(注意：false时type必须是post)
                    dataType: 'json',//这里是返回类型，一般是json,text等
                    clearForm: true,//提交后是否清空表单数据
                    success: function(data) {   //提交成功后自动执行的处理函数，参数data就是服务器返回的数据。
                        // alert(data);
                        // console.log(data)

                        // console.log(data.imgaddress)

                        // console.log(vm.syintro);
                        // $("#imgaddress").val(data.imgaddress);
                        // console.log(document.getElementById("imgaddress"));
                        var imgaddress = data.imgaddress;
                        var val = $("#introcontent").val();
                        console.log(imgaddress);
                        console.log(val);
                        var syintroEntity={
                            "imgaddress":imgaddress,
                            "introcontent":val,
                            "introid":vm.syintro.introid
                        };
                        console.log(vm.syintro.introid);
                        console.log(data.msg);
                        if(data.msg == 'success'){
                            if (vm.syintro.introid != null){
                                $.ajax({
                                    url:rul2,
                                    type:'POST',
                                    data:{"imgaddress":vm.syintro.imgaddress},
                                    dataType:'formdata',
                                    success:function (data) {
                                        console.log(data);
                                        console.log("删除成功");
                                    }
                                });
                            }

                         $.ajax({
                            type: "POST",
                            url: baseURL + url,
                            contentType: "application/json",
                            data: JSON.stringify(syintroEntity),
                            success: function(r){
                                console.log(r);
                                if(r.code == 0){
                                    layer.msg("操作成功", {icon: 1});
                                    window.location.reload();
                                    vm.reload();
                                    $('#btnSaveOrUpdate').button('reset');
                                    $('#btnSaveOrUpdate').dequeue();
                                }else{
                                    layer.alert(r.msg);
                                    $('#btnSaveOrUpdate').button('reset');
                                    $('#btnSaveOrUpdate').dequeue();
                                }
                        }
                        });
                        }
                    }
                });

			});
		},
		del: function (event) {
			var introids = getSelectedRows();
			if(introids == null){
				return ;
			}
			var lock = false;
            layer.confirm('确定要删除选中的记录？', {
                btn: ['确定','取消'] //按钮
            }, function(){
               if(!lock) {
                    lock = true;
		            $.ajax({
                        type: "POST",
                        url: baseURL + "sys/syintro/delete",
                        contentType: "application/json",
                        data: JSON.stringify(introids),
                        success: function(r){
                            if(r.code == 0){
                                layer.msg("操作成功", {icon: 1});
                                $("#jqGrid").trigger("reloadGrid");
                            }else{
                                layer.alert(r.msg);
                            }
                        }
				    });
			    }
             }, function(){
             });
		},
		getInfo: function(introid){
			$.get(baseURL + "sys/syintro/info/"+introid, function(r){
                vm.syintro = r.syintro;
                var imgaddress = vm.syintro.imgaddress;
                var introcontent = vm.syintro.introcontent;
                $("#demo1").attr("src",imgaddress);
                $("#introcontent").val(introcontent);
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                page:page
            }).trigger("reloadGrid");
            window.location.reload();
		},
        //上传文件并回显
        uploadFile : function (test1) {
            $("#file").trigger("click");
            /*
            1、先获取input标签
            2、给input标签绑定change事件
            3、把图片回显
             */
//            1、先回去input标签
            var $input = $("#file");
//            2、给input标签绑定change事件
            $input.on("change" , function(){
                //补充说明：因为我们给input标签设置multiple属性，因此一次可以上传多个文件
                //获取选择图片的个数
                var files = this.files;
                var length = files.length;
                console.log("选择了"+length+"张图片");
                //3、回显
                // for( var i = 0 ; i < length ; i++ ){


                    var fr = new FileReader(),
                        // div = document.getElementById("imgUpload"),
                        img = document.getElementById("demo1");

                    // div.className = 'pic';


                    fr.onload = function(e){
                        console.log("回显了图片")
                        img.src = this.result;
                        // div.appendChild(img)
                        // document.body.appendChild(div);
                    }
                    fr.readAsDataURL(files[0]);//读取文件
                // }

            })
        }
	}
});
