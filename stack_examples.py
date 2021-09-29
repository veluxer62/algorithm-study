# coding=utf-8
class Node:
    def __init__(self, data=None, next_=None):
        self.data = data
        self.next_ = next_

head = None
end = None


def init():
    global head, end

    head = Node()
    end = Node()
    head.next_ = end
    end.next_ = end


def push(num):
    global head

    ptr_node = Node(num)
    ptr_node.next_ = head.next_
    head.next_ = ptr_node


def pop():
    global head

    ptr_node = head.next_
    head.next_ = head.next_.next_

    return ptr_node.data


def display_stack():
    global head, end
    print('head -> ')

    index_node = head.next_
    while index_node != end:
        print(str(index_node.data) + ' -> ')
        index_node = index_node.next_

    print('end')


if __name__ == '__main__':
    init()
    push(1)
    push(3)
    push(10)
    push(20)
    push(12)

    print('다섯 번의 push() 함수 호출 후 실행 결과\n')
    display_stack()

    pop()
    pop()
    pop()

    print('세번의 pop() 함수 호출 후 실행 결과\n')
    display_stack()