class LinkedList:
    def __init__(self, value, next=None):
        self.value = value
        self.next = next

    @property
    def is_tail(self):
        return self.next is None

    def __len__(self):
        if self.is_tail:
            return 1
        else:
            return 1 + len(self.next)

