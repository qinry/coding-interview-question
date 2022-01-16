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

## 拓扑排序

指**有向无环图**的节点进行排序后得到的序列。

入度和出度：

节点v的入度表示以节点v为终点的边的数量；节点v的出度表示以节点为起点的边的数量。

拓扑排序算法：

每次从有向无环图取出一个入度为0的节点添加到拓扑排序序列中，然后删除该节点及其以它为起点的所有边。

重复该过程，直到图为空或图不存在节点入度为0的节点。

如果最终图为空，那么图是有向无环图；如果最终图不为空，且已经不存在入度为0的节点，那么图有环。

## 并查集

树形结构，表示不相交集合。并查集每一个子集是一棵树，每个元素是某棵树的节点。每个节点有一个指向父节点的指针，根节点指向自己。

有两个操作：合并与查找。

合并将两个子集合并为一个集合，只需将一子集的根节点指针指向另一子集的根节点。

查找，可用来确定元素在哪个子集中，或判断两个元素是否为同一个子集。如果两个元素的祖先节点一样，那么他们在同一个子集中。注意并查集中子集由各个子集的根节点表示。

适合解决动态连接问题。

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
* [朋友圈](src/main/java/io/dure/coding/graph/FindCircleNum.java)
* [相似的字符串](src/main/java/io/dure/coding/graph/NumSimilarGroups.java)