<%--
  Created by IntelliJ IDEA.
  User: 95632
  Date: 2019/5/25
  Time: 15:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <link rel="stylesheet" type="text/css" href="css/index.css">
    <link rel="stylesheet" href="res/layui/css/layui.css">
    <link rel="stylesheet" href="res/css/global.css">
</head>
<body style="margin: -2px">

<iframe src="head.jsp" scrolling="no" width="100%" height="90px"></iframe>

<div class="dvContent">
    <div class="dvquesleft">

        <div class="dvqstitle">
            <image class="imgbean" src="images/bean.jpg">
                <span class="qsTitle">问答</span>
                <span class="back"><a href="">《《返回上一页</a></span>
        </div>

        <div class="dvtabhead">
            <div class="tabheads tabcurrent">全部问题</div>
            <div class="tabheads">我的问题</div>
            <div class="tabheads">关注问题</div>
            <div class="tabheads">问题标签</div>
        </div>
        <div class="tabContent">
            <div class="dvtags">
                <a class="curenttag">待解决</a><span class="line"></span><a>高分</a><span
                    class="line"></span><a>新回答</a><span class="line"></span><a>已解决</a>
            </div>
            <div class="tab">

                <%--遍历这个div生成帖子--%>
                <s:iterator value="#session.pastePageBean.list" var="paste">
                    <div class="dvques">
                        <div class="quesCount">
                            <div class="count"><s:property value="#paste.ansnum"/></div>
                            <div class="ques">回答数</div>
                        </div>
                        <div class="quesContent">
                            <div class="quesTitle">
                                <s:property value="#paste.offer"/>
                                <image src="images/bean.jpg" class="bean"/>
                                <span class="spanques">
                                    <a href="${pageContext.request.contextPath}/PasteAction_getDetail?pasteid=<s:property value="#paste.id"/>">
                                    <s:property value="#paste.title"/>
                                    </a>
                                </span>
                            </div>
                            <div class="qContent"
                                 style="width:630px;height:34px;overflow: hidden;white-space: normal;text-overflow:ellipsis">
                                <p>
                                    <s:property value="#paste.content"/>
                                </p>
                            </div>
                            <div class="tags">
                                <span class="tag">excel</span><span class="tag">程序</span>
                            </div>
                            <div class="quesUser" style="margin-top: 10px; margin-left: 20px">
                                <image src="<s:property value="#paste.user.image"></s:property>" class="imguser"/>
                                <div class="userName">
                                    <s:property value="#paste.user.username"/>
                                    <div class="liulan">浏览(<s:property value="#paste.glanceover"/>) <s:property
                                            value="#paste.createtime"/></div>
                                </div>

                            </div>
                        </div>
                    </div>
                </s:iterator>

                <div style="text-align: center">
                    <div class="laypage-main">

                        <a href="${pageContext.request.contextPath }/GetDataAction_getData?currentPage=<s:property value="#session.pastePageBean.currentPage-1"/>"
                           class="laypage-next">上一页</a>
                        <a href="${pageContext.request.contextPath }/GetDataAction_getData?currentPage=1"
                           class="laypage-last" title="尾页">首页</a>
                        <%--当前页编号大于3，出来省略号--%>
                        <s:if test="#session.pastePageBean.currentPage-3>0">
                            <span>…</span>
                        </s:if>
                        <%--显示当前页面的前面两页的编号--%>
                        <s:if test="#session.pastePageBean.currentPage-2>0">
                            <a href="${pageContext.request.contextPath }/GetDataAction_getData?currentPage=<s:property value="#session.pastePageBean.currentPage-2"/>">
                                <s:property value="#session.pastePageBean.currentPage-2"/>
                            </a>
                        </s:if>
                        <s:if test="#session.pastePageBean.currentPage-1>0">
                            <a href="${pageContext.request.contextPath }/GetDataAction_getData?currentPage=<s:property value="#session.pastePageBean.currentPage-1"/>">
                                <s:property value="#session.pastePageBean.currentPage-1"/>
                            </a>
                        </s:if>
                        <!-- 当前页 -->
                        <span class="laypage-curr">
								<s:property value="#session.pastePageBean.currentPage"/>
							</span>
                        <%--最后一页的前三个以前的页，都显示当前页的后两页--%>
                        <s:if test="#session.pastePageBean.currentPage<#session.pastePageBean.totalPage">
                            <a href="${pageContext.request.contextPath }/GetDataAction_getData?currentPage=<s:property value="#session.pastePageBean.currentPage+1"/>">
                                <s:property value="#session.pastePageBean.currentPage+1"/>
                            </a>
                        </s:if>
                        <s:if test="#session.pastePageBean.currentPage+1<#session.pastePageBean.totalPage">
                            <a href="${pageContext.request.contextPath }/GetDataAction_getData?currentPage=<s:property value="#session.pastePageBean.currentPage+2"/>">
                                <s:property value="#session.pastePageBean.currentPage+2"/>
                            </a>
                        </s:if>
                        <%--当前页编号小于总编号-3，都显示省略号--%>
                        <s:if test="#session.pastePageBean.currentPage+2<#session.pastePageBean.totalPage">
                            <span>…</span>
                        </s:if>
                        <a href="${pageContext.request.contextPath }/GetDataAction_getData?currentPage=<s:property value="#session.pastePageBean.totalPage"/>"
                           class="laypage-last" title="尾页">尾页</a>

                        <a href="${pageContext.request.contextPath }/GetDataAction_getData?currentPage=<s:property value="#session.pastePageBean.currentPage+1"/>"
                           class="laypage-next">下一页</a>
                    </div>
                </div>

            </div>
            <div class="tab hidden">2</div>
            <div class="tab hidden">3</div>
            <div class="tab hidden">4</div>
        </div>
    </div>
    <div class="dvquesright">
        <div>
            <buton class="btnques" onclick="location.href='add.jsp'">提个问题</buton>
        </div>
        <div class="dvorder">
            <dl class="fly-panel fly-list-one">
                <dt class="fly-panel-title">最近热帖</dt>
                <dd>
                    <a href="">使用 layui 秒搭后台大布局（基本结构）</a> <span><i
                        class="iconfont">&#xe60b;</i> 6087</span>
                </dd>
                <dd>
                    <a href="">Java实现LayIM后端的核心代码</a> <span><i class="iconfont">&#xe60b;</i>
						767</span>
                </dd>
                <dd>
                    <a href="">使用 layui 秒搭后台大布局（基本结构）</a> <span><i
                        class="iconfont">&#xe60b;</i> 6087</span>
                </dd>
                <dd>
                    <a href="">Java实现LayIM后端的核心代码</a> <span><i class="iconfont">&#xe60b;</i>
						767</span>
                </dd>
                <dd>
                    <a href="">使用 layui 秒搭后台大布局（基本结构）</a> <span><i
                        class="iconfont">&#xe60b;</i> 6087</span>
                </dd>
                <dd>
                    <a href="">Java实现LayIM后端的核心代码</a> <span><i class="iconfont">&#xe60b;</i>
						767</span>
                </dd>
                <dd>
                    <a href="">使用 layui 秒搭后台大布局（基本结构）</a> <span><i
                        class="iconfont">&#xe60b;</i> 6087</span>
                </dd>
                <dd>
                    <a href="">Java实现LayIM后端的核心代码</a> <span><i class="iconfont">&#xe60b;</i>
						767</span>
                </dd>
            </dl>

            <dl class="fly-panel fly-list-one">
                <dt class="fly-panel-title">近期热议</dt>
                <dd>
                    <a href="">使用 layui 秒搭后台大布局之基本结构</a> <span><i
                        class="iconfont">&#xe60c;</i> 96</span>
                </dd>
                <dd>
                    <a href="">使用 layui 秒搭后台大布局之基本结构</a> <span><i
                        class="iconfont">&#xe60c;</i> 96</span>
                </dd>
                <dd>
                    <a href="">使用 layui 秒搭后台大布局之基本结构</a> <span><i
                        class="iconfont">&#xe60c;</i> 96</span>
                </dd>
                <dd>
                    <a href="">使用 layui 秒搭后台大布局之基本结构</a> <span><i
                        class="iconfont">&#xe60c;</i> 96</span>
                </dd>
                <dd>
                    <a href="">使用 layui 秒搭后台大布局之基本结构</a> <span><i
                        class="iconfont">&#xe60c;</i> 96</span>
                </dd>
                <dd>
                    <a href="">使用 layui 秒搭后台大布局之基本结构</a> <span><i
                        class="iconfont">&#xe60c;</i> 96</span>
                </dd>
                <dd>
                    <a href="">使用 layui 秒搭后台大布局之基本结构</a> <span><i
                        class="iconfont">&#xe60c;</i> 96</span>
                </dd>
                <dd>
                    <a href="">使用 layui 秒搭后台大布局之基本结构</a> <span><i
                        class="iconfont">&#xe60c;</i> 96</span>
                </dd>
            </dl>
            <div class="orderTitle">专家排行榜</div>
            <div class="users">
                <image class="userface" src="images/0.gif"/>
                <div class="dvuser">
                    <div class="userTitle">陈有龙</div>
                    <div class="userdeital">大牛6级 豆:14006</div>
                </div>
            </div>
            <div class="users">
                <image class="userface" src="images/1.gif"/>
                <div class="dvuser">
                    <div class="userTitle">陈有龙</div>
                    <div class="userdeital">大牛6级 豆:14006</div>
                </div>
            </div>
            <div class="users">
                <image class="userface" src="images/2.gif"/>
                <div class="dvuser">
                    <div class="userTitle">陈有龙</div>
                    <div class="userdeital">大牛6级 豆:14006</div>
                </div>
            </div>
            <div class="users">
                <image class="userface" src="images/3.gif"/>
                <div class="dvuser">
                    <div class="userTitle">陈有龙</div>
                    <div class="userdeital">大牛6级 豆:14006</div>
                </div>
            </div>
            <div class="users">
                <image class="userface" src="images/4.gif"/>
                <div class="dvuser">
                    <div class="userTitle">陈有龙</div>
                    <div class="userdeital">大牛6级 豆:14006</div>
                </div>
            </div>
            <div class="users">
                <image class="userface" src="images/5.gif"/>
                <div class="dvuser">
                    <div class="userTitle">陈有龙</div>
                    <div class="userdeital">大牛6级 豆:14006</div>
                </div>
            </div>
            <div class="users">
                <image class="userface" src="images/6.gif"/>
                <div class="dvuser">
                    <div class="userTitle">陈有龙</div>
                    <div class="userdeital">大牛6级 豆:14006</div>
                </div>
            </div>


        </div>

    </div>

</div>
</body>

<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
    $(function () {

        $(".tabheads").click(function () {
            $(".tabheads").removeClass("tabcurrent").eq($(this).index()).addClass("tabcurrent");
            $(".tab").hide().eq($(this).index()).show();
        });
    });
</script>

</html>


