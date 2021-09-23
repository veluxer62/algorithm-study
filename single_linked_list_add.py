# coding=utf-8
class Node:
    def __init__(self, data=None, node=None):
        self.data = data
        self.next_ = node


head = None
end = None
temp = None
temp1 = None
temp2 = None
temp3 = None
temp4 = None


def init():
    global head, end, temp1, temp2, temp3, temp4
    head = Node()
    end = Node()

    temp1 = Node('A')
    head.next_ = temp1
    temp1.next_ = end

    temp2 = Node('B')
    temp1.next_ = temp2
    temp2.next_ = end

    temp3 = Node('D')
    temp2.next_ = temp3
    temp3.next_ = end

    temp4 = Node('E')
    temp3.next_ = temp4
    temp4.next_ = end


def insert_node(node):
    global head, end

    # 2. 새로운 노드가 삽입될 노드 위치 검색
    index_node = head
    while index_node != end:
        if index_node.next_.data > node.data:
            break

        index_node = index_node.next_

    # 3. 새로운 노드의 next에 새로운 노드가 삽입될 다음 노드로 연결
    node.next_ = index_node.next_

    # 4. 새로운 노드가 삽입될 위치의 이전노드의 next가 새로운 노드를 가리키도록
    index_node.next_ = node


if __name__ == '__main__':
    init()

    ptr = head.next_

    for i in range(4):
        print(ptr.data)
        ptr = ptr.next_

    print

    # 1. 새로운 노드 생성
    temp = Node('C')

    insert_node(temp)

    ptr = head.next_

    for i in range(5):
        print(ptr.data)
        ptr = ptr.next_
