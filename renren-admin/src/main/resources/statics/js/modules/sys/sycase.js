$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/sycase/list',
        datatype: "json",
        colModel: [			
			{ label: 'caseid', name: 'caseid', index: 'caseId', width: 50, key: true },
			{ label: '论思案例学生姓名', name: 'casestudentname', index: 'caseStudentName', width: 80 }, 			
			{ label: '论思案例时间', name: 'casetime', index: 'caseTime', width: 80 }, 			
			{ label: '论思案例内容', name: 'casecontent', index: 'caseContent', width: 80 }, 			
			{ label: '论思案例图片地址', name: 'caseimgaddress', index: 'caseImgAddress', width: 80 }, 			
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
		sycase: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.sycase = {};
		},
		update: function (event) {
			var caseid = getSelectedRow();
			if(caseid == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(caseid)
		},
		saveOrUpdate: function (event) {
		    $('#btnSaveOrUpdate').button('loading').delay(1000).queue(function() {
                var url = vm.sycase.caseid == null ? "sys/sycase/save" : "sys/sycase/update";
                $.ajax({
                    type: "POST",
                    url: baseURL + url,
                    contentType: "application/json",
                    data: JSON.stringify(vm.sycase),
                    success: function(r){
                        if(r.code === 0){
                             layer.msg("操作成功", {icon: 1});
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
			});
		},
		del: function (event) {
			var caseids = getSelectedRows();
			if(caseids == null){
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
                        url: baseURL + "sys/sycase/delete",
                        contentType: "application/json",
                        data: JSON.stringify(caseids),
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
		getInfo: function(caseid){
			$.get(baseURL + "sys/sycase/info/"+caseid, function(r){
                vm.sycase = r.sycase;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                page:page
            }).trigger("reloadGrid");
		}
	}
});