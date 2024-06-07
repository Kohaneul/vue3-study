<template>
<main>
	<TemplateRefsVue></TemplateRefsVue>	
</main>
</template>

<script>
	import LifecycleHook from "./LifecycleHook.vue";
import TemplateRefsVue from "./TemplateRefs.vue";
export default{
	components:{
		TemplateRefsVue
	},
	setup(){
		return {};
	},
}
</script>
<style lang="scss" scoped>
</style>