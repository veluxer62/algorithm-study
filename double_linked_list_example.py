class Node:
    def __init__(self, data=None, prev=None, next_=None):
        self.data = data
        self.prev = prev
        self.next_ = next_

head = None
end = None


def init():
    global head, end

    head = Node()
    end = Node()

    temp1 = Node('A')
    head.next_ = temp1
    temp1.next_ = end
    temp1.prev = head
    end.next_ = end
    ptr = temp1

    temp2 = Node('B')
    ptr.next_ = temp2
    temp2.next_ = end
    temp2.prev = ptr
    ptr = temp2

    temp3 = Node('D')
    ptr.next_ = temp3
    temp3.next_ = end
    temp3.prev = ptr
    ptr = temp3

    temp4 = Node('E')
    ptr.next_ = temp4
    temp4.next_ = end
    temp4.prev = ptr


def insert_node(ptr):
    global head, end

    indexptr = head
    while indexptr != end:
        if indexptr.data < ptr.data < indexptr.next_.data:
            break
        indexptr = indexptr.next_

    ptr.next_ = indexptr.next_
    indexptr.next_.prev = ptr
    indexptr.next_ = ptr
    ptr.prev = indexptr


def delete_node(ptr):
    global head, end

    indexptr = head
    while indexptr != end:
        if indexptr.next_.data == ptr.data:
            break
        indexptr = indexptr.next_

    indexptr.next_ = indexptr.next_.next_
    indexptr.next_.next_.prev = indexptr


if __name__ == '__main__':
    init()

    ptr = head.next_
    for i in range(4):
        print(ptr.data)
        ptr = ptr.next_

    temp = Node('C')

    insert_node(temp)

    print

    ptr = head.next_
    for i in range(5):
        print(ptr.data)
        ptr = ptr.next_

    delete_node(temp)

    print

    ptr = head.next_
    for i in range(4):
        print(ptr.data)
        ptr = ptr.next_