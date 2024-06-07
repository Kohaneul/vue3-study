<template>
  <div class="container py-4">
    <input type="text" ref="input"/>
    <p>{{ input }}</p>
    <p v-if="input">{{ input.value }}, {{ $refs.input.value }},
    {{  $refs.input.value ===input.value }}</p>

    <!-- <ul>
      <li v-for="fruit in fruits" :key="fruit" :ref="(el)=>itemRefs.push(el.textContent)">{{ fruit }}</li>
    </ul> -->
    <hr>
    <TemplateRefsChild ref="child"></TemplateRefsChild>
  </div>
</template>
<script>
import {ref,onMounted} from "vue";
import TemplateRefsChild from "./TemplateRefsChild.vue";
export default{
  components: { TemplateRefsChild },

    setup() { 
        const input = ref(null);
        const child = ref(null);
        const itemRefs = ref([]);
        const fruits = ref(['사과', '딸기', '포도']);
        onMounted(() => {
            input.value.value = "Hello World";
            console.log("onMounted: ",input.value);
            itemRefs.value.forEach(i => {
                console.log("item : " + i);
            });
            console.log('child.message: ',child.value.message);
            child.value.sayHello();
        });
        return { input, fruits, itemRefs,child };
    },
}
</script>
<style lang="scss" scoped></style>