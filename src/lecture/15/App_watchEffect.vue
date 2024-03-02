<template>
	<div>
		<!-- <form action="" @submit.prevent="save(title,contents)"> -->
		<form @submit.prevent>
			<input v-model.lazy="title" type="text" placeholder="title"/>
			<br>
			<textarea v-model.lazy="contents" placeholder="Contents"></textarea>
			<button @click="save(title,contents)">저장</button>
		</form>
	</div>
</template>

<script>
import{ref,watchEffect} from 'vue'
export default {
	setup () {
		const title = ref('');
		const contents = ref('');
		const save=(title,contents)=>{
			console.log(`저장 되었습니다. title : ${title}, contents : ${contents}`)
		}
		watchEffect(()=>{
			console.log('watch Effect');
			save(title.value,contents.value);
			console.log(title.value);
			console.log(contents.value);
		})
		return {title,contents,save};
	}
}
</script>

<style lang="scss" scoped>

</style>