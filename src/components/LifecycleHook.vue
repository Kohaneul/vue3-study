<template>
  <div class="container py-4">
  <input ref="inputRef" type="text" value="hello World"/>
  <hr>
  <button @click="visible = !visible">Toggle Child</button>
  <LifecycleChild v-if="visible"></LifecycleChild>
 <p id="message"> {{ message }}</p>
  </div>
</template>
<script>
import { onBeforeMount, onBeforeUpdate, onMounted,onUpdated,ref } from 'vue';
import LifecycleChild from './LifecycleChild.vue';

export default{
  components:{
    LifecycleChild
  },
  setup(){
    const inputRef = ref(null);
    const message = ref('');
    const visible = ref(false);
    console.log('setup');
    onBeforeMount(()=>{
      console.log('onBeforeMount',inputRef.value);
    });
    onMounted(()=>{
      console.log('onMounted',inputRef.value.value)
    });

      // onBeforeUpdate(()=>{
      //   console.log('onBeforeUpdate',message.value);
      //  const messageRef =  document.querySelector('#message').textContent;
      //   console.log("DOM content : "+messageRef);
      // })
      // onUpdated(()=>{
      //   console.log('onUpdated',message.value);
      //   const messageRef =  document.querySelector('#message').textContent;
      //   console.log("DOM content : "+messageRef);
      // })
    return {inputRef,message,visible};
  }, 
  // data:()=>({
  //   dataMessage:'data-message',
  // }),
  // beforeCreate(){
  //   console.log('beforeCreate',this.dataMessage);
  //   console.log(this.dataMessage);
  // },
  // created(){
  //   console.log('created',this.dataMessage);
  // }
}</script>

<style lang="scss" scoped>
</style>