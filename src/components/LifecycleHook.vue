<template>
  <div class="container py-4">
    <input ref="inputRef" type="text" value="hello world"/>
    <hr>
    <button @click="visible = !visible">Toggle Child</button>
    <LifecycleChild v-if="visible"></LifecycleChild>
    <p id="message">{{ message }}</p>
  </div>
</template>
<script>
import{onMounted, onBeforeMount,ref,computed,onBeforeUpdate,onUpdated} from 'vue';
import LifecycleChild from './LifecycleChild.vue';
export default{
  components:{
    LifecycleChild,
  },
  setup(){
    // console.log('setup');
    const inputRef = ref(null);
    const message = ref('');
    const visible=ref(false);
    // onBeforeUpdate(()=>{
    //   console.log('onBeforeUpdate',message.value);
    //   console.log("DOM Content : ",document.querySelector('#message').textContent);
    // })
    // onUpdated(()=>{
    //   console.log('onUpdated',message.value);
    //   console.log("DOM Content : ",document.querySelector('#message').textContent);
    //   console.log("======================");

    // })
    return {inputRef,message,visible}
  },  
}
</script>
<style lang="scss" scoped></style>