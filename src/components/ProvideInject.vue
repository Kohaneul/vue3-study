<template>
  <main>
    <div class="container py-4">
      <div class="card">
        <div class="card-header">Provide Inject Component</div>
        <div class="card-body">     
          <button @click="count++">Click</button>
           {{ appMessage }}
           {{ msg }}
          <Child></Child>
        </div>

      </div>
    </div>
  </main>
  </template>
  <script>
  import { provide,ref,readonly, inject } from "vue";
import Child from "./Child.vue";
  export default{
    components:{Child},
    setup(){
      const staticMessage = 'static Message';
      const message = ref('message');
      const count = ref(10);
      const updateMessage = (appendMessage)=>{
        message.value = message.value+appendMessage;
      }
      console.log(this);

      provide('static-message',staticMessage)
      provide('message',{message:readonly(message),updateMessage})
      provide('count',count)
      const msg = inject('msg');
      const appMessage = inject('app-message');
      return {count,appMessage,msg}
    },
    mounted(){
      console.log('this.msg : '+this.msg);
    }
  }
  </script>
  <style lang="scss" scoped>
  </style>