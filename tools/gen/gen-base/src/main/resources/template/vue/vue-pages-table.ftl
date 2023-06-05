<template>
    <div>
        <el-card class="pageLayout">
            <#--查询-->
            <el-form ref="form" :model="form" :inline="true">

                <#list codeTable.columnList as column>
                    <#if column.isKey == 0>
                        <el-form-item label="${column.columnComment!""}">
                            <#if column.type == "Date">
                                <el-date-picker
                                        v-model.trim="form.${column.name}"
                                        type="date"
                                        placeholder="选择日期">
                                </el-date-picker>
                            <#else>
                                <el-input v-model.trim="form.${column.name}"></el-input>
                            </#if>
                        </el-form-item>
                    </#if>
                </#list>
                <el-form-item>
                    <el-button type="primary" @click="handleCheck" icon="el-icon-search">查询</el-button>
                    <el-button type="info" @click="handleReset" icon="el-icon-refresh">重置</el-button>
                </el-form-item>
            </el-form>
            <div style="margin-bottom: 20px;">
                <el-button type="primary" @click="handleAdd('新增')" icon="el-icon-plus" size="mini">新增</el-button>
            </div>
            <#--表格-->
            <el-table ref="multipleTable" :data="dataList" tooltip-effect="dark" border>
                <#list codeTable.columnList as column>
                    <el-table-column label="${column.columnComment!""}" prop="${column.name}">
                    </el-table-column>
                </#list>
                <el-table-column label="操作" width="250px">
                    <template slot-scope="scope">
                        <el-tooltip class="item" effect="dark" content="编辑">
                            <el-button type="info" icon="el-icon-edit" size="mini"
                                       @click="handleEdit(scope.row,'编辑')"></el-button>
                        </el-tooltip>
                        <el-tooltip class="item" effect="dark" content="删除">
                            <el-button type="info" icon="el-icon-delete" size="mini"
                                       @click="handleDelete(scope.row.id)"></el-button>
                        </el-tooltip>
                    </template>
                </el-table-column>
            </el-table>
            <el-pagination layout="prev, pager, next" :total="total" :page-size.sync="size" :current-page.sync="current"
                           @current-change='handleChange' style="text-align: right">
            </el-pagination>
            <TableSave ref="modalForm" @ok="medelok">
            </TableSave>
        </el-card>
    </div>
</template>

<script>
    //{
    //path: "/${entityName?lower_case}Table",
    //name: "/${entityName?lower_case}Table",
    //component: () =>
    //import("@/views/pages/${codeConfig.moduleName?lower_case}/${entityName?cap_first}Table")
    //},
    import {getAction} from "@/api/requestor"
    import {publicData} from "@/minxins/public"

    import TableSave from "./components/TableSave"

    export default {
        name: "${entityName?lower_case}Table",
        mixins: [publicData],
        data() {
            return {
                dataList: [],
                total: 0,
                size: 12,
                current: 1,
                url: {

                    delete: "/${entityName?uncap_first}/deleteById",
                    list: "/${entityName?uncap_first}/pageList"
                },
                form: {
            <#if codeTable.columnList??>
            <#list codeTable.columnList as column>
            ${column.name}:
            ''<#if column_has_next>,
            </#if>
            </#list>
            </#if>
        }
        }
        },
        components: {
            ${entityName?lower_case}Save
        },
        mounted() {
            this.loadData()
        },
        methods: {
            // 获取表格数据
            loadData() {
                const params = {
                    'current': this.current,
                    'size': this.size,
                <#if codeTable.columnList??>
                <#list codeTable.columnList as column>
                ${column.name}:
                this.form.${column.name}<#if column_has_next>,
                </#if>
                </#list>
                </#if>
            }
                getAction(this.url.list, params).then(res => {
                    if (res.data.code == 200) {
                        this.dataList = res.data.data.records
                        this.total = res.data.data.total
                    } else {
                        this.$message.info(res.data.msg)
                    }

                }).catch(err => {

                })

            },
        }
    }
</script>

<style scoped>

</style>
