import { mount } from '@vue/test-utils'
import Dynamic from './dynamic.js';

global.axios = {
    get() { return Promise.resolve({ data: []})},
    post() { return Promise.resolve('value')}
}

test('shows empty list message', () => {
    const wrapper = mount(Dynamic);
    expect(wrapper.text()).toContain('Es gibt gute Nachrichten! du hast keine Todos');
})

test('should clear name input', async() => {
    const wrapper = mount(Dynamic);
    const todoInput = wrapper.find('input[type="text"]');
    await todoInput.setValue('Ein neues ToDo');
    await wrapper.find('button').trigger('click');
    expect(wrapper.vm.$data.todoField).toBe('');
})