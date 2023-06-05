<template>
    <div>
        <el-card class="box-card">
            <#--查询-->
            <el-form ref="form" :model="form" :inline="true">
                <el-form-item label="年份">
                    <el-date-picker
                            type="year"
                            v-model.trim="form.year"
                            format="yyyy"
                            value-format="yyyy"
                            placeholder="请选择年份"
                    ></el-date-picker>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="handleCheck" icon="el-icon-search">查询</el-button>
                    <el-button type="info" @click="handleReset" icon="el-icon-refresh">重置</el-button>
                </el-form-item>
            </el-form>
            <div style="margin-bottom: 20px;">
                <el-button type="primary" @click="handleAdd('新增')" icon="el-icon-plus" size="mini">新增</el-button>
            </div>
            <#--表格-->
            <el-table ref="multipleTable" :data="dataList" tooltip-effect="dark" border :span-method="objectSpanMethod">
                <#list codeTable.columnList as column>
                    <el-table-column label="${column.columnComment!""}" prop="${column.name}">
                    </el-table-column>
                </#list>
                <el-table-column label="操作" width="250px">
                    <template slot-scope="scope">
                        <el-tooltip class="item" effect="dark" content="编辑">
                            <el-button type="info" icon="el-icon-edit" size="mini"
                                       @click="handleEdit(scope.row.year,'编辑')"></el-button>
                        </el-tooltip>
                        <el-tooltip class="item" effect="dark" content="删除">
                            <el-button type="info" icon="el-icon-delete" size="mini"
                                       @click="handleDeletes(scope.row.year)"></el-button>
                        </el-tooltip>
                    </template>
                </el-table-column>
            </el-table>
            <el-pagination layout="prev, pager, next" :total="total" :page-size.sync="size" :current-page.sync="current"
                           @current-change='handleChange'>
            </el-pagination>
            <${entityName?lower_case}Save ref="modalForm" @ok="medelok">
            </${entityName?lower_case}Save>
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

    import ${entityName?lower_case}Save from "./components/${entityName?cap_first}Save"

    export default {
        name: "${entityName?lower_case}Table",
        mixins: [publicData],
        data() {
            return {
                dataList: [],
                total: 0,
                size: 3,
                current: 1,
                url: {
                    delete: "/${entityName?uncap_first}/deleteByYear",
                    list: "/${entityName?uncap_first}/pageList"
                },
                form: {year: ''},
                codeList: []
            }
        },
        components: {
            ${entityName?lower_case}Save
        },
        mounted() {
            this.$api.code("${codeConfig.dictCode}").then(res => {
                if (res.data.code == 200) {
                    this.codeList = res.data.data
                }
            })
            this.loadData()
        },
        methods: {
            objectSpanMethod({row, column, rowIndex, columnIndex}) {
                if (columnIndex === 0 || columnIndex == 12) {
                    if (rowIndex % this.codeList.length === 0) {
                        return {
                            rowspan: this.codeList.length,
                            colspan: 1,
                        };
                    } else {
                        return {
                            rowspan: 0,
                            colspan: 0,
                        };
                    }
                }
            },
            // 获取表格数据
            loadData() {
                const params = {
                    'current': this.current,
                    'size': this.size,
                    'year': this.form.year,
                }
                getAction(this.url.list, params).then(res => {
                    if (res.data.code == 200) {
                        var stringdata = [];
                        if (res.data.data.records.length > 0) {
                            res.data.data.records.forEach((val) => {
                                if (val.list == null) {

                                } else {
                                    val.list.forEach((e) => {
                                        stringdata.push(e);
                                    });
                                }

                                this.dataList = stringdata;
                            });
                        } else {
                            this.dataList = [];
                        }
                        this.total = res.data.data.total;
                    } else {
                        this.$message.info(res.data.msg);
                    }

                }).catch(err => {

                })

            },
        }
    }
</script>

<style scoped>

</style>
