<template>
	<div>
		<h2>input Value</h2>
		<!-- <input type="text" :value="inputValue" @input="event=>(inputValue=event.target.value)"> -->
		<!-- <div>
		<input type="text" v-model="inputValue"/>
		</div> -->
		<!-- <div> lazy -> change 이벤트 후 동기화
		<input type="text" v-model.lazy="inputValue"/>
		</div> -->
		<!-- <div>number
		<input type="text" v-model.number="inputValue"/>
		</div> -->
		<div>trim
		<input type="text" v-model.trim="inputValue"/>
		</div>
		<div>{{ inputValue }}</div>
		<div>{{ typeof inputValue }}</div>

	<hr/>
		<h2>text area value</h2>
		<!-- <textarea name="" id="" cols="30" rows="10" :value="textAreaValue" @input ="event=>(textAreaValue = event.target.value)"></textarea> -->
		<textarea v-model="textareaValue"></textarea>	
		<div>{{ textareaValue }}</div>

	<h2>checkbox value</h2>
	<label for="checkbox">{{ checkboxValue }}</label>
	<!-- <input type="checkbox" id = "checkbox" :checked="checkboxValue" 
	@change="event=>(checkboxValue = event.target.checked)"/> -->
	<input type="checkbox" v-model="checkboxValue" true-value="Yes" false-value="No">
	
	<hr/>
	<h2>checkbox values</h2>
	<label>
	<input type="checkbox" value="HTML" v-model="checkboxValues">HTML
	</label>
	<label>
	<input type="checkbox" value = "CSS" v-model="checkboxValues">CSS
	</label>
	<label>
	<input type="checkbox" value = "JavaScript" v-model="checkboxValues">JavaScript
	</label>
	<div>{{ checkboxValues }}</div>
	<hr/>
	<h2>radio value</h2>
		<!-- <label> <input type="radio" name="type" value="O" :checked="radioValue==='O'"
			@change="event=>(radioValue = event.target.value)">O형</label>
		<br>
		<label> <input type="radio" name="type" value="A" :checked="radioValue==='A'"
			@change = "event=>(radioValue = event.target.value)">A형</label>
		<br>
		<label> <input type="radio" name="type" value="B" :checked="radioValue==='B'"
			@change = "event=>(radioValue = event.target.value)">B형</label> -->
			<label> <input type="radio" name="type" value="O" v-model="radioValue">O형</label>
		<br>
		<label> <input type="radio" name="type" value="A" v-model="radioValue">A형</label>
		<br>
		<label> <input type="radio" name="type" value="B" v-model="radioValue">B형</label>
		<div>{{ radioValue }}</div>

		<hr/>
			<h2>select Value</h2>
			<!-- <select :value="selectValue" @change="selectValue=event.target.value"> -->
			<select v-model="selectValue">
				<option value="html">HTML</option>
				<option value="css">CSS</option>
				<option value="javascript">JavaScript</option>
			</select>
			<div>{{ selectValue }}</div>


	</div>
	

</template>

<script>
import {ref} from 'vue';
	export default {
		setup(){
			const inputValue = ref(null);
			const textareaValue = ref(null);
			const checkboxValue = ref('Yes');
			const checkboxValues = ref([]);
			const radioValue = ref('O');
			const selectValue = ref('html')

			return {inputValue,textareaValue,checkboxValue,radioValue,selectValue,checkboxValues};
		}
	}
</script>

<style lang="scss" scoped>

</style>