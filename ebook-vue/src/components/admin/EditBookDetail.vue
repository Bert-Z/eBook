<template>
  <div class="editbookdetail">
    <Row>
      <Col offset="4" span="16">
        <Card style="padding-top: 20px">
          <Form ref="formValidate" :model="formValidate" :rules="ruleValidate" :label-width="80">
            <FormItem label="Title" prop="title">
              <Input v-model="formValidate.title" placeholder="Enter the book title"></Input>
            </FormItem>

            
            <FormItem label="LargeCate" prop="LargeCate">
              <Select v-model="formValidate.cate2" placeholder="Select the book LargeCate" @on-change="getcate1((formValidate.allCategories,formValidate.cate2))">
                <Option v-for="(value,name,index) in formValidate.allCategories" :value="name">{{name}}</Option>
              </Select>
            </FormItem>
            
            <FormItem label="SmallCate" prop="SmallCate">
              <Select v-model="formValidate.cate_id" placeholder="Select the book SmallCate">
                <Option v-for="item in formValidate.cate1" :key="item[1]" :value="item[1]">{{item[0]}}</Option>
              </Select>
            </FormItem>
          

            <FormItem label="Author" prop="author">
              <Input v-model="formValidate.author" placeholder="Enter the book author"></Input>
            </FormItem>
            <FormItem label="Price" prop="price">
              <Input v-model="formValidate.price" placeholder="Enter the book price"></Input>
            </FormItem>
            <FormItem label="Desc" prop="desc">
              <Input v-model="formValidate.desc" type="textarea" :autosize="{minRows: 2,maxRows: 5}"
                     placeholder="Enter something about the book..."></Input>
            </FormItem>
            <FormItem>
              <input type="file" accept="image/*" ref="fileToUpload" name="fileToUpload" id="fileToUpload" @change="uploadFile()"/>
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
        bookimage:null,
        formValidate: {
          title: '',
          price: null,
          cate2: '',
          cate1:[],
          desc: '',
          allCategories:{},
          cate_id:''
        },
        ruleValidate: {
          title: [
            {required: true, message: 'The title cannot be empty', trigger: 'blur'}
          ],
          price: [
            {required: true, message: 'The price cannot be empty', trigger: 'blur'},
          ],
          author: [
            {required: true, message: 'The author cannot be empty', trigger: 'blur'},
          ],
          // LargeCate: [
          //   {required: true, message: 'Please select the LargeCate', trigger: 'change'}
          // ],
          // SmallCate: [
          //   {required: true, message: 'Please select the SmallCate', trigger: 'change'}
          // ],
          desc: [
            {required: true, message: 'Please enter a personal introduction', trigger: 'blur'},
          ]
        }
      }
    },
    methods: {
      handleSubmit(name) {
        // this.$refs[name].validate((valid) => {
          // if (valid) {
            let data={'bookinfo':this.formValidate,"bookimage":this.bookimage};
            this.$http.post("http://localhost:8080/admin/addBook",data,{emulateJSON: true}
            ).then(function(res){
              this.$Message.success('Success!');
              // console.log(res);

            },function(error){
              this.$Message.error('Delete Fail!');
              console.log(error);
            })
          // } else {
          //   this.$Message.error('Wrong Input!');
          // }
        // })
      },
      getAllCategorys(){
        this.$http({
          method: "GET",
          url: "http://localhost:8080/api/getAllCategorys",
          emulateJSON: true
        }).then(
          function (response) {
            this.formValidate.allCategories = response.data;
            // console.log(response.data);
            // console.log(this.formValidate.allCategories);
          }, function (error) {
            console.log(error);
          }
        )
      },
      uploadFile(){
        this.bookimage=this.$refs.fileToUpload.files[0];
        console.log(this.bookimage);
      },
      getcate1(){
        this.formValidate.cate1=this.formValidate.allCategories[this.formValidate.cate2];
      },
      handleReset(name) {
        this.$refs[name].resetFields();
      },
    },
  
    created (){
      this.getAllCategorys();
    },  
  }
</script>

<style scoped>
  .editbookdetail {
    margin-top: 50px;
  }
</style>
