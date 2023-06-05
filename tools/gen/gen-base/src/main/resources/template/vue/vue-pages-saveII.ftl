<template>
    <div>
        <el-dialog
                :title="title"
                :visible.sync="dialogVisible"
                width="50%"
                :show-close="true"
                :close-on-click-modal="false"
                @close="diolagClose"
                v-dialogDrag
        >
            <el-form :model="model" :rules="rule" ref="registerRef" label-width="100px">
                <el-row>
                    <el-col :span="12">
                        <el-form-item label="年份" prop="year">

                            <el-date-picker type="year"
                                            v-model.trim="model.year"
                                            value-format="yyyy" placeholder="请输入年份"
                                            style="width: 260px" :disabled="!disableSubmit">
                            </el-date-picker>
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-row v-for="(item,index) in model.dataList">
                    <el-divider content-position="left">{{item.normName}}</el-divider>
                    <#list codeTable.columnList as column>
                        <#if column.isKey == 0 && column.columnName?lower_case != "year">
                            <el-col :span="12">
                                <el-form-item label="${column.columnComment!""}" :prop="`${"dataList.$"+"{index}"}.${column.name}`" :rules='rule.${column.name}'>
                                        <#if column.type == "Date">
                                            <el-date-picker
                                                    v-model.trim="model.${column.name}"
                                                    type="date"
                                                    placeholder="选择${column.columnComment!""}日期">
                                            </el-date-picker>
                                        <#else>
                                            <el-input-number v-model.trim="item.${column.name}"
                                                      placeholder="请输入${column.columnComment!""}"></el-input-number>
                                        </#if>
                                </el-form-item>
                            </el-col>
                        </#if>
                    </#list>
                </el-row>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button type="primary" @click="submitForm('registerRef')">确 定</el-button>
                <el-button @click="dialogVisible=false">取 消</el-button>
            </div>
        </el-dialog>
    </div>
</template>

<script>

    import {httpAction} from "@/api/requestor"

    export default {
        name: "${entityName?lower_case}Save",
        data() {
            return {
                model: { year:'',
                    dataList: [],},
                disableSubmit: false,
                dialogVisible: false,
                url: {
                    add: '/${entityName?uncap_first}/insert',
                    edit: '/${entityName?uncap_first}/update'
                },
                title: '',
                rule: {
            <#if codeTable.columnList??><#list codeTable.columnList as column>
            ${column.name}:
            {
                required:true, message
            :
                "${'请填写'+column.columnComment!""}", trigger
            :
                'blur'
            }
            <#if column_has_next>,</#if></#list></#if>
        },
        codeList: [],
        }
        },
        mounted() {
            this.$api.code("${codeConfig.dictCode}").then(res => {
                if (res.data.code == 200) {
                    this.codeList = res.data.data
                }
            })
        },
        methods: {
            add() {
                this.edit({})
            },
            edit(record) {
                this.model.dataList = []
                this.record = record
                if (JSON.stringify(record) == "{}") {
                    this.model.year=""
                    this.codeList.forEach(val => {
                        this.model.dataList.push({
                            norm: val.state,
                            normName: val.name,

                        })
                    })
                } else {
                    //export const ${entityName?lower_case} = (params) => getAction(baseurl + "/${entityName?lower_case}/findByYear", params);
                    this.model.year = record.toString()
                    this.$api.${entityName?lower_case}({
                        year: this.model.year
                    }).then(res => {
                        if (res.data.code == 200) {
                            this.model.dataList = res.data.data.list
                        }
                    })
                }
                this.dialogVisible = true;
            },
            submitForm(formName) {
                const that = this;
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        let httpurl = '';
                        if (!this.model.id) {
                            httpurl += this.url.add;
                        } else {
                            httpurl += this.url.edit;
                        }
                        httpAction(httpurl, {
                            year: this.model.year,
                            list: this.model.dataList
                        }).then((res) => {
                            if (res.data.code == 200) {
                                that.$message.success("操作成功");
                                that.$emit('ok');
                                this.dialogVisible = false
                            } else {
                                that.$message.warning("操作失败");
                            }
                        })
                    }

                })
            },
            diolagClose(){
                this.$refs['registerRef'].resetFields();
            },
        }
    }
</script>

<style scoped>

</style>
