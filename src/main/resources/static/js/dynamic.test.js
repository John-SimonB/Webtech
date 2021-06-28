import {mount} from '@vue/test-utils'
import Dynamic from './dynamicalt.js';

global.axios = {
    get() { return Promise.resolve({ data: []})},
    post() { return Promise.resolve('value')}
}

test('shows empty list message', () => {
    const wrapper = mount(Dynamic);
    expect(wrapper.text()).toContain('Es gibt gute Nachrichten! du hast keine Todos');
})
