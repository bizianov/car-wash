var path = require('path');
var webpack = require('webpack');
var HtmlWebpackPlugin = require('html-webpack-plugin');

module.exports = {
    devServer: {
        disableHostCheck: true
    },
    target: 'node',
    context: path.join(__dirname, "src"),
    devtool: 'source-map',
    entry: {
        app: "./app.js",
    },
    resolve: {
        modules: [
            path.resolve(__dirname),
            "node_modules"
        ],
        extensions: ['.js', '.html']
    },

    module: {
        loaders: [
            {
                test: /\.js$/,
                exclude: /node_modules/,
                loader: 'babel-loader',
            }
        ]
    },

    output: {
        path: path.join(__dirname, 'src'),
        filename: "bundle.js",
        publicPath: "/"
    },

    plugins: [
        new HtmlWebpackPlugin({
            template: __dirname + "/src/index.tmpl.html"
        }),
        new webpack.DefinePlugin({
            'process.env': {
                'NODE_ENV': JSON.stringify(process.env.NODE_ENV || "dev"),
            }
        })
    ],
};