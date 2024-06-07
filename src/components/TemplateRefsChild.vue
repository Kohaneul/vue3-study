<template>
  <div>
    <!-- <button @click="sayHello">클릭</button> -->
    <div>{{ $parent }}
    
      <ul>
        <li v-for="fruit in $parent.fruits" :key="fruit">
        {{ fruit }}</li>
      </ul>
    </div>
  </div>
</template>
<script>
import {ref} from 'vue'
export default{
  setup(){
    const message=ref('Hello ~!');
    const sayHello=()=>{
      alert(message.value);
    }
    return {sayHello,message};
  }
}
</script>
<style lang="scss "></style>