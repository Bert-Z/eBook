<template>
  <div class="editbookdetail">
    <Row>
      <Col offset="4" span="16">
        <Card style="padding-top: 20px">
          <Form ref="formValidate" :model="formValidate" :rules="ruleValidate" :label-width="80">
            <FormItem label="Title" prop="title">
              <Input v-model="formValidate.title" placeholder="Enter the book title"></Input>
            </FormItem>
            <FormItem label="Type" prop="type">
              <Select v-model="formValidate.type" placeholder="Select the book type">
                <Option value="1">Education</Option>
                <Option value="2">History</Option>
                <Option value="3">Science</Option>
              </Select>
            </FormItem>
            <FormItem label="Price" prop="price">
              <Input v-model="formValidate.price" placeholder="Enter the book price"></Input>
            </FormItem>
            <FormItem label="Desc" prop="desc">
              <Input v-model="formValidate.desc" type="textarea" :autosize="{minRows: 2,maxRows: 5}"
                     placeholder="Enter something about the book..."></Input>
            </FormItem>
            <FormItem>
              <Upload
                multiple
                type="drag"
                max-size="5M"
                action="//jsonplaceholder.typicode.com/posts/">
                <div style="padding: 20px 0">
                  <Icon type="ios-cloud-upload" size="52" style="color: #3399ff"></Icon>
                  <p>Click or drag book image here to upload</p>
                </div>
              </Upload>
            </FormItem>

            <FormItem>
              <Button type="primary" @click="handleSubmit('formValidate')">Submit</Button>
              <Button @click="handleReset('formValidate')" style="margin-left: 8px">Reset</Button>
            </FormItem>
          </Form>
        </Card>
      </Col>
    </Row>
  </div>
</template>

<script>
  export default {
    name: "EditBookDetail",
    data() {
      return {
        formValidate: {
          title: '',
          price: null,
          type: '',
          desc: ''
        },
        ruleValidate: {
          title: [
            {required: true, message: 'The title cannot be empty', trigger: 'blur'}
          ],
          price: [
            {required: true, message: 'The price cannot be empty', trigger: 'blur'},
          ],
          type: [
            {required: true, message: 'Please select the type', trigger: 'change'}
          ],
          desc: [
            {required: true, message: 'Please enter a personal introduction', trigger: 'blur'},
            {type: 'string', min: 20, message: 'Introduce no less than 20 words', trigger: 'blur'}
          ]
        }
      }
    },
    methods: {
      handleSubmit(name) {
        this.$refs[name].validate((valid) => {
          if (valid) {
            this.$Message.success('Success!');
          } else {
            this.$Message.error('Fail!');
          }
        })
      },
      handleReset(name) {
        this.$refs[name].resetFields();
      }
    }
  }
</script>

<style scoped>
  .editbookdetail {
    margin-top: 50px;
  }
</style>
