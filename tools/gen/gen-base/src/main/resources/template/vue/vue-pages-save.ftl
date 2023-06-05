<template>
    <div>
        <el-dialog
                :title="title"
                :visible.sync="dialogVisible"
                width="50%"
                :show-close="true"
                :close-on-click-modal="false"
                v-dialogDrag
        >
            <el-form :model="model" :rules="rule" ref="registerRef" label-width="130px">
                <el-row>
                    <#list codeTable.columnList as column>
                        <#if column.isKey == 0>
                            <el-col :span="12">
                                <el-form-item label="${column.columnComment!""}" prop="${column.name}">
                                    <#if column.type == "Date">
                                        <el-date-picker
                                                v-model.trim="model.${column.name}"
                                                type="date"
                                                placeholder="选择${column.columnComment!""}日期">
                                        </el-date-picker>
                                    <#else>
                                        <el-input v-model.trim="model.${column.name}"
                                                  placeholder="请输入${column.columnComment!""}"></el-input>
                                    </#if>
                                </el-form-item>
                            </el-col>
                        </#if>
                    </#list>
                </el-row>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button @click="dialogVisible=false">取 消</el-button>
                <el-button type="primary" @click="submitForm('registerRef')">确 定</el-button>
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
                model: {},
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
                required:true, message:"${'请填写'+column.columnComment!""}", trigger:'blur'
            }
            <#if column_has_next>,</#if></#list></#if>
        },
        }
        },
        mounted() {

        },
        methods: {
            add() {
                this.edit({})
            },
            edit(record) {
                if (this.$refs['registerRef'] !== undefined) {
                    this.$refs['registerRef'].resetFields();
                }
                this.model = Object.assign({}, record);
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
                        httpAction(httpurl, this.model).then((res) => {
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
            }
        }
    }
</script>

<style scoped>

</style>
