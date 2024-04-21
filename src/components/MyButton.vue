<template>
  <div class="p-3 bg-danger">  
    <button class="btn btn-primary" type="button" @click="sayHello">My Button</button>
  </div>

</template>

<script>
export default {
  // inheritAttrs:false,
  emits:['click'],
  setup (props, {emit}) {
    const sayHello=()=>{
      emit('click');
    }
    // console.log('context.attrs :' ,context.attrs);
    // console.log('id :' ,context.attrs.id);
    // console.log('class :' ,context.attrs.class);
    // console.log('onClick :' ,context.onClick);

    return {sayHello}
  }
}
</script>

<style lang="scss" scoped>

</style>