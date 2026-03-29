class Solution {
public:
    int countComponents(int n, vector<vector<int>>& edges) {
        int res = 0;
        unordered_map<int,vector<int>> graph;
        unordered_set<int> visited;

        for (vector<int> e : edges) {
            graph[e[0]].push_back(e[1]);
            graph[e[1]].push_back(e[0]);
        }

        for (auto &pair : graph) {
            int node = pair.first;
            if (visited.count(node))
                continue;
            res++;
            queue<int> q;
            q.push(node);

            while (q.size()) {
                int curr = q.front();
                q.pop();
                if (visited.count(curr))
                    continue;
                vector<int> &adj = graph[curr];
                visited.insert(curr);

                for (int adj_node : adj) {
                    if (visited.count(adj_node)){
                        continue;
                    }
                    q.push(adj_node);
                }
            }
        }

        return (res + (n - graph.size()));
    }
};
