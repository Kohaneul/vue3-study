MyButton.vue

<template>
  <div class="p-3 bg-danger">
    <button class="btn btn-primary" type="button" @click="sayHello">My Button</button>
  </div>
</template>

<script>
  export default {
    // inheritAttrs:false,
    emits:['click'],
    setup(props,{emit}){
      // console.log('context.attrs : '+context.attrs);
      // console.log(context.attrs.class);
      // console.log(context.attrs.id);
      // console.log(context.attrs.onClick);
      const sayHello = ()=>{
        emit('sayHello');
        alert('hi');
      }
      return {sayHello}
    }
  }
</script>

<style lang="scss" scoped>

</style>
