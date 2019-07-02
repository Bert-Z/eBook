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
            <FormItem label="Number" prop="number">
              <Input v-model="formValidate.number" placeholder="Enter the book number"></Input>
            </FormItem>
            <FormItem label="Desc" prop="desc">
              <Input v-model="formValidate.desc" type="textarea" :autosize="{minRows: 2,maxRows: 5}"
                     placeholder="Enter something about the book..."></Input>
            </FormItem>
            <FormItem>
              <input type="file" accept="image/*" ref="fileToUpload" name="fileToUpload" id="fileToUpload" @change="uploadFile()"/>
            </FormItem>

            <img :src="formValidate.image"/>
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
        id:null,
        bookimage:null,
        formValidate: {
          title: '',
          price: null,
          cate2: '',
          cate1:[],
          number:null,
          desc: '',
          allCategories:{},
          cate_id:null,
          image:null
        },
        ruleValidate: {
          // title: [
          //   {required: true, message: 'The title cannot be empty', trigger: 'blur'}
          // ],
          // price: [
          //   {required: true, message: 'The price cannot be empty', trigger: 'blur'},
          // ],
          // number: [
          //   {required: true, message: 'The number cannot be empty', trigger: 'blur'},
          // ],
          // author: [
          //   {required: true, message: 'The author cannot be empty', trigger: 'blur'},
          // ],
          // desc: [
          //   {required: true, message: 'Please enter a personal introduction', trigger: 'blur'},
          // ]
        }
      }
    },
    methods: {
      getInfos: function () {
        this.$http({
          method: 'GET',
          url: 'http://localhost:8080/ebook/bookdetails?id=' + this.$route.query.id,
          emulateJSON: true
        }).then(
          function (response) {
            let info = response.data;
            this.formValidate.title = info.booktitle;
            this.formValidate.price = info.bookfee;
            this.formValidate.desc = info.description;
            this.formValidate.number = info.number;
            this.formValidate.cate_id = info.category.id;
            this.formValidate.author=info.auther;
            this.formValidate.cate2=info.category.category2;
            // this.formValidate.cate2=info.category.category2;
            this.formValidate.image=info.image;
            
          }, function (error) {
            console.log(error);
          })
      },
      handleSubmit(name) {
        // this.$refs[name].validate((valid) => {
        //   if (valid) {
          if(this.$route.query.id!==undefined){
            if(this.bookimage!==null){
              var reader = new FileReader();
              reader.readAsDataURL(this.bookimage, 'UTF-8');
              var urlData;
              
              let that=this;
              reader.onload = function (e) {
                  // urlData就是对应的文件内容
                  urlData = this.result;
                  that.formValidate.image=urlData;
                
                  let uploaddata={"id":that.id,"title":that.formValidate.title,"price":that.formValidate.price,"number":that.formValidate.number,"cate_id":that.formValidate.cate_id,"author":that.formValidate.author,"desc":that.formValidate.desc,"bookimage":urlData};
                  that.$http.post("http://localhost:8080/admin/modifyBook",uploaddata,{emulateJSON: true}
                  ).then(function(res){
                    
                    that.$Message.success('Success!');
                    this.$router.push({ name: 'Admin'});
                    // console.log(res);

                  },function(error){
                    that.$Message.error('Delete Fail!');
                    console.log(error);
                  })

              };

            }else{
              let that=this;

              let uploaddata={"id":that.id,"title":that.formValidate.title,"price":that.formValidate.price,"number":that.formValidate.number,"cate_id":that.formValidate.cate_id,"author":that.formValidate.author,"desc":that.formValidate.desc,"bookimage":that.formValidate.image};

              that.$http.post("http://localhost:8080/admin/modifyBook",uploaddata,{emulateJSON: true}
              ).then(function(res){
                
                that.$Message.success('Success!');
                this.$router.push({ name: 'Admin'});
                // console.log(res);

              },function(error){
                that.$Message.error('Delete Fail!');
                console.log(error);
              })
            }
          }else{
            var reader = new FileReader();
            reader.readAsDataURL(this.bookimage, 'UTF-8');
            var urlData;
            
            var that=this;
            reader.onload = function (e) {
                // urlData就是对应的文件内容
                urlData = this.result;
                // console.log(urlData);
                
          
                let uploaddata={"title":that.formValidate.title,"price":that.formValidate.price,"number":that.formValidate.number,"cate_id":that.formValidate.cate_id,"author":that.formValidate.author,"desc":that.formValidate.desc,"bookimage":urlData};


                that.$http.post("http://localhost:8080/admin/addBook",uploaddata,{emulateJSON: true}
                ).then(function(res){
                  
                  that.$Message.success('Success!');
                  this.$router.push({ name: 'Admin'});
                  // console.log(res);

                },function(error){
                  that.$Message.error('Delete Fail!');
                  console.log(error);
                })

            };
          }
          
            
            // console.log(reader.readyState);
            // console.log(reader.result);
            
            
        //   } else {
        //     this.$Message.error('Wrong Input!');
        //   }
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
        // console.log(this.bookimage);
      },
      getcate1(){
        this.formValidate.cate1=this.formValidate.allCategories[this.formValidate.cate2];
      },
      handleReset(name) {
        this.$refs[name].resetFields();
      },
    },
  
    created (){
      console.log(this.$route.query.id);
      if(this.$route.query.id!==undefined){
        this.id=this.$route.query.id;
        this.getInfos();
      }
      this.getAllCategorys();
    },  
  }
</script>

<style scoped>
  .editbookdetail {
    margin-top: 50px;
  }
</style>
