(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([[3],{"C/va":function(t,a,s){"use strict";var e=s("y3w9");t.exports=function(){var t=e(this),a="";return t.global&&(a+="g"),t.ignoreCase&&(a+="i"),t.multiline&&(a+="m"),t.unicode&&(a+="u"),t.sticky&&(a+="y"),a}},FPsY:function(t,a,s){"use strict";s.r(a);var e=function(){var t=this,a=t.$createElement,s=t._self._c||a;return s("div",{staticClass:"single-page-con"},[s("div",{staticClass:"cangkuSeachBox"},[s("Row",[t.btnFlag?s("Col",{attrs:{span:"4"}},[s("div",{staticClass:"cangkuSeach"},[s("span",[t._v("仓库编码")]),s("Select",{staticStyle:{width:"60%"},attrs:{clearable:"",filterable:""},on:{"on-change":function(a){t.sels(t.params)}},model:{value:t.params.storeCode,callback:function(a){t.$set(t.params,"storeCode",a)},expression:"params.storeCode"}},t._l(t.cityList,function(a,e){return s("Option",{key:e,attrs:{value:a.storeCode}},[t._v(t._s(a.storeName))])}))],1)]):t._e(),t.btnFlag?s("Col",{attrs:{span:"4"}},[s("div",{staticClass:"cangkuSeach"},[s("span",[t._v("商品编码")]),s("Input",{staticStyle:{width:"60%"},attrs:{placeholder:"商品名称..."},model:{value:t.params.productCode,callback:function(a){t.$set(t.params,"productCode",a)},expression:"params.productCode"}})],1)]):t._e(),s("Col",{attrs:{span:"4"}},[s("div",{staticClass:"cangkuSeach"},[s("span",[t._v("商品名称")]),s("Input",{staticStyle:{width:"60%"},attrs:{placeholder:"商品名称..."},model:{value:t.params.productName,callback:function(a){t.$set(t.params,"productName",a)},expression:"params.productName"}})],1)]),s("Col",{attrs:{span:"8"}},[s("div",{staticClass:"cangkuSeach"},[s("Button",{attrs:{type:"primary"},on:{click:t.changelist}},[t._v("高级过滤")])],1)])],1),s("Row",{staticStyle:{"margin-top":"20px"}},[s("Col",{attrs:{span:"6"}},[s("Button",{attrs:{type:"ghost",shape:"circle",icon:"ios-search"},on:{click:function(a){t.init(t.params,"edit")}}},[t._v("查询商品")]),s("Button",{staticStyle:{"margin-left":"30px"},attrs:{type:"primary",icon:"plus-round"},on:{click:t.newShangpin}},[t._v("新建商品")])],1)],1)],1),s("div",{staticClass:"cangkuList"},[s("h1",{staticClass:"CklistTitle"},[t._v("商品列表")]),s("Table",{attrs:{stripe:"",border:"",loading:t.loading,columns:t.columns7,data:t.data6,height:"500"}})],1),s("div",{staticClass:"cangkuPages"},[s("Page",{attrs:{total:t.total,"show-sizer":"","page-size":t.params.size,current:t.params.index},on:{"on-change":t.changePage,"on-page-size-change":t.changePageSize}})],1),s("Modal",{attrs:{title:"修改商品"},on:{"on-ok":function(a){t.ok(t.paramsEdit)},"on-cancel":t.cancel},model:{value:t.modal1,callback:function(a){t.modal1=a},expression:"modal1"}},[s("ul",{staticClass:"SPcont"},[s("li",[s("Row",[s("Col",{attrs:{span:"24"}},[s("span",{staticClass:"intit"},[t._v("\n          仓库编号\n        ")]),s("Select",{staticStyle:{width:"60%"},attrs:{clearable:""},on:{"on-change":function(a){t.sels(t.paramsEdit)}},model:{value:t.paramsEdit.storeCode,callback:function(a){t.$set(t.paramsEdit,"storeCode",a)},expression:"paramsEdit.storeCode"}},t._l(t.cityList,function(a,e){return s("Option",{key:e,attrs:{value:a.storeCode}},[t._v(t._s(a.storeCode))])}))],1)],1)],1),s("li",[s("Row",[s("Col",{attrs:{span:"24"}},[s("span",{staticClass:"intit"},[t._v("\n          商品编号\n        ")]),s("Input",{staticStyle:{width:"60%"},attrs:{placeholder:"请输入商品编号..."},model:{value:t.paramsEdit.productCode,callback:function(a){t.$set(t.paramsEdit,"productCode",a)},expression:"paramsEdit.productCode"}})],1)],1)],1),s("li",[s("Row",[s("Col",{attrs:{span:"24"}},[s("span",{staticClass:"intit"},[t._v("\n          商品名称\n        ")]),s("Input",{staticStyle:{width:"60%"},attrs:{placeholder:"请输入商品名称..."},model:{value:t.paramsEdit.productName,callback:function(a){t.$set(t.paramsEdit,"productName",a)},expression:"paramsEdit.productName"}})],1)],1)],1),s("li",[s("Row",[s("Col",{attrs:{span:"24"}},[s("span",{staticClass:"intit"},[t._v("\n          库存个数\n        ")]),s("Input",{staticStyle:{width:"60%"},attrs:{placeholder:"请输入库存个数..."},on:{"on-blur":function(a){t.reg(t.paramsEdit.inventory)}},model:{value:t.paramsEdit.inventory,callback:function(a){t.$set(t.paramsEdit,"inventory","string"===typeof a?a.trim():a)},expression:"paramsEdit.inventory"}})],1)],1)],1)])])],1)},n=[],i=(s("Oyvg"),s("91GP"),s("yt8O"),s("VRzm"),s("vDqi")),o=s.n(i),r={name:"cangku",data:function(){var t=this;return{btnFlag:!1,loading:!0,modal1:!1,cityList:[],params:{index:1,size:20,productCode:"",productName:"",storeCode:"",storeName:""},paramsEdit:{},paramsEditDatas:{},columns7:[{title:"仓库编号",key:"storeCode",render:function(t,a){return t("div",[t("Icon",{props:{type:"person"}}),t("strong",a.row.storeCode)])}},{title:"仓库名称",key:"storeName"},{title:"商品编号",key:"productCode"},{title:"商品名称",key:"productName"},{title:"库存个数",key:"inventory"},{title:"操作",key:"action",width:150,align:"center",render:function(a,s){return a("div",[a("Button",{props:{type:"primary",size:"small"},style:{marginRight:"5px"},on:{click:function(){t.edit(s.index)}}},"修改"),a("Button",{props:{type:"error",size:"small"},on:{click:function(){t.remove(s.index)}}},"删除")])}}],data6:[],total:0,index:0}},methods:{edit:function(t){this.modal1=!0,this.modal1&&(this.cangkulist(),this.paramsEdit=Object.assign({},this.data6[t]),this.paramsEditDatas=this.data6[t],this.index=t)},remove:function(t){var a=this,s=this;this.$Modal.confirm({title:"删除商品",closable:!0,content:"商品名称：".concat(this.data6[t].productName,"<br>仓库名称：").concat(this.data6[t].storeName),onOk:function(){o.a.delete(s.baseUrl+"/product/"+a.data6[t].id).then(function(a){a.data.suc?(s.$Message.success({content:a.data.msg,duration:3}),s.data6.splice(t,1)):s.$Message.error({content:a.data.msg,duration:3})})}})},changelist:function(){this.btnFlag=!this.btnFlag,this.btnFlag?this.cangkulist():(this.params.productCode="",this.params.storeCode="")},newShangpin:function(){this.$router.push({name:"newshangpin"})},init:function(t,a){"edit"==a&&(this.params.index=1,this.params.size=20);var s=this;s.loading=!0,o.a.get(s.baseUrl+"/product",{params:t}).then(function(t){s.loading=!1,t.data.suc?(s.data6=t.data.obj,s.total=t.data.total):(s.$Message.warning(t.data.msg),s.data6=t.data.obj)}).catch(function(t){s.loading=!1,console.log(t)})},changePage:function(t){this.params.index=t,this.init(this.params)},changePageSize:function(t){this.params.size=t,this.init(this.params)},ok:function(t){var a=this;o.a.put(a.baseUrl+"/product",t).then(function(t){t.data.suc?(a.$Message.info({content:t.data.msg,duration:3}),a.init(a.params)):a.$Message.error("修改失败,"+t.data.msg)}).catch(function(t){a.$Message.error({content:t,duration:3})})},cancel:function(){this.$Message.info("取消修改")},cangkulist:function(){var t=this;o.a.get(t.baseUrl+"/store").then(function(a){a.data.suc&&(t.cityList=a.data.obj)}).catch(function(t){console.log(t)})},sels:function(t){for(var a=0;a<this.cityList.length;a++)this.cityList[a].storeName==t.storeName&&((t.storeCode=void 0)?this.cityList[a].storeCode==t.storeCode&&(t.storeName=this.cityList[a].storeName):this.cityList[a].storeName="")},reg:function(t){var a=new RegExp("^[1-9]\\d*|0$");""!=t&&(a.test(t)?parseInt(t)>99999&&this.$Message.warning({content:"请输入0~99999的数值",duration:3}):this.$Message.warning({content:"请输入数字",duration:3}))}},computed:{datas:function(){return this.data6[this.index]=this.paramsEdit}},created:function(){this.init(this.params)}},c=r,l=(s("UBbj"),s("GyOg")),d=Object(l["a"])(c,e,n,!1,null,"1c7a9a49",null);a["default"]=d.exports},Oyvg:function(t,a,s){var e=s("dyZX"),n=s("Xbzi"),i=s("hswa").f,o=s("kJMx").f,r=s("quPj"),c=s("C/va"),l=e.RegExp,d=l,u=l.prototype,p=/a/g,m=/a/g,h=new l(p)!==p;if(s("nh4g")&&(!h||s("eeVq")(function(){return m[s("K0xU")("match")]=!1,l(p)!=p||l(m)==m||"/a/i"!=l(p,"i")}))){l=function(t,a){var s=this instanceof l,e=r(t),i=void 0===a;return!s&&e&&t.constructor===l&&i?t:n(h?new d(e&&!i?t.source:t,a):d((e=t instanceof l)?t.source:t,e&&i?c.call(t):a),s?this:u,l)};for(var g=function(t){t in l||i(l,t,{configurable:!0,get:function(){return d[t]},set:function(a){d[t]=a}})},f=o(d),v=0;f.length>v;)g(f[v++]);u.constructor=l,l.prototype=u,s("KroJ")(e,"RegExp",l)}s("elZq")("RegExp")},UBbj:function(t,a,s){"use strict";var e=s("l5kE"),n=s.n(e);n.a},l5kE:function(t,a,s){}}]);
//# sourceMappingURL=3.39e607c6.js.map