$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/syteacher/list',
        datatype: "json",
        colModel: [			
			{ label: 'teacherid', name: 'teacherid', index: 'teacherId', width: 50, key: true },
			{ label: '老师姓名', name: 'teachername', index: 'teacherName', width: 80 }, 			
			{ label: '老师简介', name: 'teacherintro', index: 'teacherIntro', width: 80 }, 			
			{ label: '老师讲课风格', name: 'teacherstyle', index: 'teacherStyle', width: 80 }, 			
			{ label: '老师对学生的一句话', name: 'teacherforstudent', index: 'teacherForStudent', width: 80 }, 			
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
		syteacher: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.syteacher = {};
		},
		update: function (event) {
			var teacherid = getSelectedRow();
			if(teacherid == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(teacherid)
		},
		saveOrUpdate: function (event) {
		    $('#btnSaveOrUpdate').button('loading').delay(1000).queue(function() {
                var url = vm.syteacher.teacherid == null ? "sys/syteacher/save" : "sys/syteacher/update";
                $.ajax({
                    type: "POST",
                    url: baseURL + url,
                    contentType: "application/json",
                    data: JSON.stringify(vm.syteacher),
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
			var teacherids = getSelectedRows();
			if(teacherids == null){
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
                        url: baseURL + "sys/syteacher/delete",
                        contentType: "application/json",
                        data: JSON.stringify(teacherids),
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
		getInfo: function(teacherid){
			$.get(baseURL + "sys/syteacher/info/"+teacherid, function(r){
                vm.syteacher = r.syteacher;
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