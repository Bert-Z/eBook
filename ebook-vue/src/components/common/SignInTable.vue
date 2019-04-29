<template>
  <div class="signintable">
    <Row>
      <Col offset="4" span="16">
        <Card style="padding-top: 20px">
          <h3 class="box-title m-b-0">Welcome to E-Book</h3>
          <Divider></Divider>
          <Form ref="formCustom" :model="formCustom" :rules="ruleCustom" :label-width="80">
            <FormItem label="Name" prop="name">
              <Input type="text" placeholder="Name" v-model="formCustom.name"></Input>
            </FormItem>
            <FormItem label="Password" prop="passwd">
              <Input type="password" placeholder="Password" v-model="formCustom.passwd"></Input>
            </FormItem>
            <FormItem style="text-align: center;">
              <Button type="primary" @click="handleSubmit('formCustom')" style="margin-left: -60px">Sign In</Button>
              <Button @click="handleReset('formCustom')" style="margin-left: 8px">Reset</Button>
            </FormItem>
          </Form>
          <div class="form-group m-b-0">
            <div class="col-sm-12 text-center">
              <p>Does not have an account? <router-link class="text-danger m-l-5" :to="{name:'SignUp'}"><b>Sign Up</b></router-link></p>
            </div>
          </div>
        </Card>
      </Col>
    </Row>
  </div>
</template>

<script>
  import {getCookie,setCookie} from '../../util/util'

  export default {
    name: "SignInTable",
    data() {
      const validatePass = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('Please enter your password'));
        } else {
          callback();
        }
      };
      return {
        formCustom: {
          passwd: '',
          name: '',
        },
        ruleCustom: {
          passwd: [
            {required: true, validator: validatePass, trigger: 'blur'}
          ],
          name: [
            {required: true, message: 'The name cannot be empty', trigger: 'blur'}
          ],
        }
      }
    },
    mounted(){
      if(getCookie("name")){
        this.$router.push({name:"Index"});
      }
    },
    methods: {
      findUser:function(){
        let data={"name":this.formCustom.name,"password":this.formCustom.passwd};
        this.$http.post("http://localhost:8080/user/signin",data,{emulateJSON: true}
).then(function(res){
          // console.log(res.data);
          // console.log(this.formCustom.name);
          if(res.data===1){
            this.$Message.success('Success!');
            setCookie('name', this.formCustom.name,1000*60);
            setTimeout(function(){
              this.$router.push({name:"Index"});
            }.bind(this),1000)

          }else if(res.data===0){
            this.$Message.error('没有找到用户!');
          }else{
            this.$Message.error('用户被禁用');
          }

        },function(error){
          this.$Message.error('Fail!');
          console.log(error);
        })
      },
      handleSubmit(name) {
        this.$refs[name].validate((valid) => {
          if (valid) {
            // this.$Message.success('Success!');
            this.findUser();
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
  .signintable {
    margin-top: 50px;
  }
</style>
