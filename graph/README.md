# Graph

## 基础知识

由一系列的节点通过边联系起来的数据结构。可以表示物体与物体之间的关系。图的实现有邻接矩阵和邻接链表实现。

邻接链表为图中的每个节点创建一个容器，每i个容器保存所有与i相邻的节点。

如果图有n个节点，那么就创建n*n大小的邻接矩阵M。节点i和节点j之间有关系，M[i][j]等于1，反之无关系，M[i][j]等于0。

图按方向可分有向图和无向图。如果边规定了方向，就是有向图。无向图的边没有方向，但可以看作所有的边规定了双向.

按边是否有权重可分有权图和无权图。有权图意味着，每条边都有一个数值权重，用来表示两个节点的某种关系，如两个节点的距离等。无权图中所有边都没权重。

## 图的搜索

广度优先搜索和深度优先搜索。广度优先搜索是系统地展开并检查图中的所有节点并以找寻结果。深度优先搜索是沿图中的边尽可能深入地搜索。

广度优先搜索能够在无权图中从某个起始节点出发用最短的距离达到目标节点。在无权图中，两个节点的距离通常是连通两个节点的路径经过的节点的数目。

如果访问与某一节点相邻的节点的顺序不同，那么深度优先搜索算法从起点开始到达某节点的路径不同。所以深度优先搜索从一个节点到另一个节点并不能保证是最短路径。但广度优先搜索可以。

关于路径的问题可以考虑深度优先搜索。关于最短距离可以考虑广度优先搜索。

如果图的节点有v个，边有e个，那么无论深度优先搜索还是广度优先搜索，每个节点只会访问一次并且沿着每条判断与某个节点相邻节点是否已经访问过，时间复杂度为O(v+e)。

## 二分图

如果任意一条边的两个节点被涂上不同的颜色，整个图就是二分图。

## 题目

* [最大面积的岛屿](src/main/java/io/dure/coding/graph/MaxAreaOfIsland.java)
* [二分图](src/main/java/io/dure/coding/graph/IsBipartite.java)
* [矩阵中的距离](src/main/java/io/dure/coding/graph/UpdateMatrix.java)
* [单词演变](src/main/java/io/dure/coding/graph/LadderLength.java)
* [开密码锁](src/main/java/io/dure/coding/graph/OpenLock.java)
* [所有路径](src/main/java/io/dure/coding/graph/AllPathSourceTarget.java)
* [计算除法](src/main/java/io/dure/coding/graph/CalcEquation.java)
* [最长递增路径](src/main/java/io/dure/coding/graph/LongestIncreasingPath.java)
* [课程顺序](src/main/java/io/dure/coding/graph/FindOrder.java)
* [外星文字典](src/main/java/io/dure/coding/graph/AlienOrder.java)
* [重建序列](src/main/java/io/dure/coding/graph/SequenceReconstruction.java)