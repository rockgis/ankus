/*
 * Copyright (C) 2011  Flamingo Project (http://www.opencloudengine.org).
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

/**
 * NodeMetaCommon Store
 *
 * @class
 * @extends Ext.data.Store
 * @author <a href="mailto:hrkenshin@gmail.com">Seungbaek Lee</a>
 */
Ext.define('Flamingo.store.designer.NodeMetaCommon', {
    extend: 'Ext.data.Store',
    alias: 'store.NodeMetaCommon',
    storeId:'NodeMetaCommon',
    id:'NodeMetaCommon',
           
    model: 'Flamingo.model.designer.NodeMeta',
    
    autoLoad:true, 
    proxy: {
        type: 'ajax',
        url:'/getmoduleinfos',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json; charset=utf-8;'
        },
        reader: { 
            type: 'json',
            root: 'applist',
            successProperty: 'success'
        },     
        actionMethods: {
            read: 'POST'
        }        
    },
    listeners:{
      load:function(store, record, success, opts){ 
    	  
    	  store.data.removeAll();
    	  
    	  Ext.each(this.nodeData, function(obj){    		 
	    	  store.add(obj);
	      });
    	  
    	  //console.info(store.data.items);
    	  if(record != null){
    		  var response_text = store.proxy.reader.rawData;
    		  
    		  //console.info(response_text.length);
    		  for(i=0; i< response_text.length; i++){  
        		  store.add({
                   	  "type": response_text[i].appgroup,        			  
                   	  "icon": "/getmoduleresource?jarfile=" + response_text[i].path + "&resource=" + response_text[i].appicon,
                   	  "jobType": "MAPREDUCE",
                   	  "identifier": "ALG_ANKUS_COMMON_INPUT",
                   	  "name": response_text[i].appname,
                   	  "qualifierLabel": response_text[i].classname,
                   	  "description": "Apache Pig Latin Script",
                   	  "isCheckColumns": false,
                   	  "fixedInputColumns": false,
                   	  "fixedOutputColumns": false,
                   	  "readOnlyOutputColumns": false,
                   	  "ignoreInput": true,
                   	  "ignoreOutput": true,
                   	  "minPrevNodeCounts": 1,
                   	  "maxPrevNodeCounts": 1,
                   	  "minNextNodeCounts": 1,
                   	  "maxNextNodeCounts": -1,
                   	  "notAlloedPrevTypes": "",
                   	  "notAllowedNextTypes": "",
                   	  "notAllowedPrevNodes": "",
                   	  "notAllowedNextNodes": "",
                   	  "className":response_text[i].classname
                     });  
        	  }  
    	  }
    	  //console.info(store.data);
      }      
     
    },    	
    nodeData: [
               {
                   "type": "START",
                   "identifier": "START",
                   "name": "Start",
                   "minPrevNodeCounts": 0,
                   "maxPrevNodeCounts": 0,
                   "minNextNodeCounts": 1,
                   "maxNextNodeCounts": -1,
                   "notAllowedPrevTypes": "",
                   "notAllowedNextTypes": "END,IN,OUT",
                   "notAllowedPrevNodes": "",
                   "notAllowedNextNodes": "END",
                   "className":"START"
                   	
               },
               {
                   "type": "END",
                   "identifier": "END",
                   "name": "End",
                   "minPrevNodeCounts": 1,
                   "maxPrevNodeCounts": -1,
                   "minNextNodeCounts": 0,
                   "maxNextNodeCounts": 0,
                   "notAllowedPrevTypes": "START,IN,OUT",
                   "notAllowedNextTypes": "",
                   "notAllowedPrevNodes": "START",
                   "notAllowedNextNodes": "",
                   "className":"END"
               },
              
               {
                   "type": "STATISTICS",
                   "icon": CONSTANTS.CONTEXT_PATH + "/resources/images/ankus_icon_v2/stats_numeric.png",
                   "jobType": "MAPREDUCE",
                   "identifier": "ALG_ANKUS_NUMERIC_STATISTICS",
                   "name": "Numeric Statistics (Distribution)",
                   "qualifierLabel": "anumstat",
                   "description": "Numeric Statistics (Distribution)",
                   "isCheckColumns": false,
                   "fixedInputColumns": false,
                   "fixedOutputColumns": false,
                   "readOnlyOutputColumns": false,
                   "ignoreInput": true,
                   "ignoreOutput": true,
                   "minPrevNodeCounts": 0,
                   "maxPrevNodeCounts": -1,
                   "minNextNodeCounts": 0,
                   "maxNextNodeCounts": -1,
                   "notAllowedPrevTypes": "",
                   "notAllowedNextTypes": "",
                   "notAllowedPrevNodes": "",
                   "notAllowedNextNodes": "",
                   "className":"NumericStatistics"
               },
               {
                   "type": "STATISTICS",
                   "icon": CONSTANTS.CONTEXT_PATH + "/resources/images/ankus_icon_v2/stats_norminal.png",
                   "jobType": "MAPREDUCE",
                   "identifier": "ALG_ANKUS_NOMINAL_STATISTICS",
                   "name": "Nominal Statistics (Distribution)",
                   "qualifierLabel": "nominal",
                   "description": "Nominal Statistics (Distribution)",
                   "isCheckColumns": false,
                   "fixedInputColumns": false,
                   "fixedOutputColumns": false,
                   "readOnlyOutputColumns": false,
                   "ignoreInput": true,
                   "ignoreOutput": true,
                   "minPrevNodeCounts": 0,
                   "maxPrevNodeCounts": -1,
                   "minNextNodeCounts": 0,
                   "maxNextNodeCounts": -1,
                   "notAllowedPrevTypes": "",
                   "notAllowedNextTypes": "",
                   "notAllowedPrevNodes": "",
                   "notAllowedNextNodes": "",
                   "className":"NominalStatistics"
               },
               {
                   "type": "STATISTICS",
                   "icon": CONSTANTS.CONTEXT_PATH + "/resources/images/ankus_icon_v2/stats_cfsum.png",
                   "jobType": "MAPREDUCE",
                   "identifier": "ALG_ANKUS_CERTAIN_FACTOR_SUM",
                   "name": "Certainty Factor based Sum",
                   "qualifierLabel": "acfs",
                   "description": "Ceratinnty Factor based Sum 확신도 기반 합계",
                   "isCheckColumns": false,
                   "fixedInputColumns": false,
                   "fixedOutputColumns": false,
                   "readOnlyOutputColumns": false,
                   "ignoreInput": true,
                   "ignoreOutput": true,
                   "minPrevNodeCounts": 0,
                   "maxPrevNodeCounts": -1,
                   "minNextNodeCounts": 0,
                   "maxNextNodeCounts": -1,
                   "notAllowedPrevTypes": "",
                   "notAllowedNextTypes": "",
                   "notAllowedPrevNodes": "",
                   "notAllowedNextNodes": "",
                   "className":"CertaintyFactorBasedSum"
               },
               {
                   "type": "PREPROCESSING",
                   "icon": CONSTANTS.CONTEXT_PATH + "/resources/images/ankus_icon_v2/pre_normalization.png",
                   "jobType": "MAPREDUCE",
                   "identifier": "ALG_ANKUS_NORMAL",
                   "name": "Min/Max Normalization",
                   "qualifierLabel": "anormal",
                   "description": "데이터 전처리를 위한 데이터 정규화",
                   "isCheckColumns": false,
                   "fixedInputColumns": false,
                   "fixedOutputColumns": false,
                   "readOnlyOutputColumns": false,
                   "ignoreInput": true,
                   "ignoreOutput": true,
                   "minPrevNodeCounts": 0,
                   "maxPrevNodeCounts": -1,
                   "minNextNodeCounts": 0,
                   "maxNextNodeCounts": -1,
                   "notAllowedPrevTypes": "",
                   "notAllowedNextTypes": "",
                   "notAllowedPrevNodes": "",
                   "notAllowedNextNodes": "",
                   "className":"MinMaxNormalization"
               } ,       
               {
                   "type": "PREPROCESSING",
                   "icon": CONSTANTS.CONTEXT_PATH + "/resources/images/ankus_icon_v2/ETL.png",
                   "jobType": "MAPREDUCE",
                   "identifier": "ALG_ANKUS_ETL",
                   "name": "ETL",
                   "qualifierLabel": "aetl",
                   "description": "ETL ",
                   "isCheckColumns": false,
                   "fixedInputColumns": false,
                   "fixedOutputColumns": false,
                   "readOnlyOutputColumns": false,
                   "ignoreInput": true,
                   "ignoreOutput": true,
                   "minPrevNodeCounts": 0,
                   "maxPrevNodeCounts": -1,
                   "minNextNodeCounts": 0,
                   "maxNextNodeCounts": -1,
                   "notAllowedPrevTypes": "",
                   "notAllowedNextTypes": "",
                   "notAllowedPrevNodes": "",
                   "notAllowedNextNodes": "",
                   "className":"ETL"
               },
               {
                   "type": "PREPROCESSING",
                   "icon": CONSTANTS.CONTEXT_PATH + "/resources/images/ankus_icon_v2/Discretization.png",
                   "jobType": "MAPREDUCE",
                   "identifier": "ALG_ANKUS_DISCRETIZATION",
                   "name": "EM Discretization",
                   "qualifierLabel": "adiscretization",
                   "description": "Discretization ",
                   "isCheckColumns": false,
                   "fixedInputColumns": false,
                   "fixedOutputColumns": false,
                   "readOnlyOutputColumns": false,
                   "ignoreInput": true,
                   "ignoreOutput": true,
                   "minPrevNodeCounts": 0,
                   "maxPrevNodeCounts": -1,
                   "minNextNodeCounts": 0,
                   "maxNextNodeCounts": -1,
                   "notAllowedPrevTypes": "",
                   "notAllowedNextTypes": "",
                   "notAllowedPrevNodes": "",
                   "notAllowedNextNodes": "",
                   "className":"EMDiscretization"
               },       
               {
                   "type": "CORRELATION",
                   "icon": CONSTANTS.CONTEXT_PATH + "/resources/images/ankus_icon_v2/simcorr_row_binary.png",
                   "jobType": "MAPREDUCE",
                   "identifier": "ALG_ANKUS_CORR_BOOL",
                   "name": "Boolean Similarity/Correlation",
                   "qualifierLabel": "acorrb",
                   "description": "Boolean Data Set 벡터 형식의 데이터 기반 유사/상관 분석",
                   "isCheckColumns": false,
                   "fixedInputColumns": false,
                   "fixedOutputColumns": false,
                   "readOnlyOutputColumns": false,
                   "ignoreInput": true,
                   "ignoreOutput": true,
                   "minPrevNodeCounts": 0,
                   "maxPrevNodeCounts": -1,
                   "minNextNodeCounts": 0,
                   "maxNextNodeCounts": -1,
                   "notAllowedPrevTypes": "",
                   "notAllowedNextTypes": "",
                   "notAllowedPrevNodes": "",
                   "notAllowedNextNodes": "",
                   "className":"BooleanSimilarityCorrelation"
               },
               {
                   "type": "CORRELATION",
                   "icon": CONSTANTS.CONTEXT_PATH + "/resources/images/ankus_icon_v2/simcorr_row_numeric.png",
                   "jobType": "MAPREDUCE",
                   "identifier": "ALG_ANKUS_CORR_NUMERIC",
                   "name": "Numeric Similarity/Correlation",
                   "qualifierLabel": "acorrn",
                   "description": "Numeric Data Set 벡터 형식의 데이터 기반 유사/상관 분석",
                   "isCheckColumns": false,
                   "fixedInputColumns": false,
                   "fixedOutputColumns": false,
                   "readOnlyOutputColumns": false,
                   "ignoreInput": true,
                   "ignoreOutput": true,
                   "minPrevNodeCounts": 0,
                   "maxPrevNodeCounts": -1,
                   "minNextNodeCounts": 0,
                   "maxNextNodeCounts": -1,
                   "notAllowedPrevTypes": "",
                   "notAllowedNextTypes": "",
                   "notAllowedPrevNodes": "",
                   "notAllowedNextNodes": "",
                   "className":"NumericSimilarityCorrelation"
               },
               {
                   "type": "CORRELATION",
                   "icon": CONSTANTS.CONTEXT_PATH + "/resources/images/ankus_icon_v2/simcorr_row_string.png",
                   "jobType": "MAPREDUCE",
                   "identifier": "ALG_ANKUS_CORR_STRING",
                   "name": "String Similarity",
                   "qualifierLabel": "acorrs",
                   "description": "String Data Set 벡터 형식의 데이터 기반 유사/상관 분석",
                   "isCheckColumns": false,
                   "fixedInputColumns": false,
                   "fixedOutputColumns": false,
                   "readOnlyOutputColumns": false,
                   "ignoreInput": true,
                   "ignoreOutput": true,
                   "minPrevNodeCounts": 0,
                   "maxPrevNodeCounts": -1,
                   "minNextNodeCounts": 0,
                   "maxNextNodeCounts": -1,
                   "notAllowedPrevTypes": "",
                   "notAllowedNextTypes": "",
                   "notAllowedPrevNodes": "",
                   "notAllowedNextNodes": "",
                   "className":"StringSimilarity"
               },        
               {
                   "type": "CORRELATION",
                   "icon": CONSTANTS.CONTEXT_PATH + "/resources/images/ankus_icon_v2/simcorr_column.png",
                   "jobType": "MAPREDUCE",
                   "identifier": "ALG_ANKUS_CORR_COLUMN",
                   "name": "Column based Similarity/Correlationn",
                   "qualifierLabel": "acorrs",
                   "description": "Column 데이터의 속성간 유사/상관/거리 분석",
                   "isCheckColumns": false,
                   "fixedInputColumns": false,
                   "fixedOutputColumns": false,
                   "readOnlyOutputColumns": false,
                   "ignoreInput": true,
                   "ignoreOutput": true,
                   "minPrevNodeCounts": 0,
                   "maxPrevNodeCounts": -1,
                   "minNextNodeCounts": 0,
                   "maxNextNodeCounts": -1,
                   "notAllowedPrevTypes": "",
                   "notAllowedNextTypes": "",
                   "notAllowedPrevNodes": "",
                   "notAllowedNextNodes": "",
                   "className":"ColumnBasedSimilarityCorrelationn"
               },        
               {
                   "type": "ASSOCIATION",
                   "icon": CONSTANTS.CONTEXT_PATH + "/resources/images/ankus_icon_v2/FPGrowth.png",
                   "jobType": "MAPREDUCE",
                   "identifier": "ALG_ANKUS_FPGWOWTH",
                   "name": "FPGrowth",
                   "qualifierLabel": "afpgrowth",
                   "description": "FPGrowth",
                   "isCheckColumns": false,
                   "fixedInputColumns": false,
                   "fixedOutputColumns": false,
                   "readOnlyOutputColumns": false,
                   "ignoreInput": true,
                   "ignoreOutput": true,
                   "minPrevNodeCounts": 0,
                   "maxPrevNodeCounts": -1,
                   "minNextNodeCounts": 0,
                   "maxNextNodeCounts": -1,
                   "notAllowedPrevTypes": "",
                   "notAllowedNextTypes": "",
                   "notAllowedPrevNodes": "",
                   "notAllowedNextNodes": "",
                   "className":"FPGrowth"
               },  
               {
                   "type": "CLASSIFICATION",
                   "icon": CONSTANTS.CONTEXT_PATH + "/resources/images/ankus_icon_v2/ml_classify_id3.png",
                   "jobType": "MAPREDUCE",
                   "identifier": "ALG_ANKUS_ID3",
                   "name": "ID3 Classification",
                   "qualifierLabel": "aid3",
                   "description": "ID3 based Classification",
                   "isCheckColumns": false,
                   "fixedInputColumns": false,
                   "fixedOutputColumns": false,
                   "readOnlyOutputColumns": false,
                   "ignoreInput": true,
                   "ignoreOutput": true,
                   "minPrevNodeCounts": 0,
                   "maxPrevNodeCounts": -1,
                   "minNextNodeCounts": 0,
                   "maxNextNodeCounts": -1,
                   "notAllowedPrevTypes": "",
                   "notAllowedNextTypes": "",
                   "notAllowedPrevNodes": "",
                   "notAllowedNextNodes": "",
                   "className":"ID3Classification"
               },
               {
                   "type": "CLASSIFICATION",
                   "icon": CONSTANTS.CONTEXT_PATH + "/resources/images/ankus_icon_v2/NaiveBayes.png",
                   "jobType": "MAPREDUCE",
                   "identifier": "ALG_ANKUS_NAIVE_BAYES",
                   "name": "Naive Bayes Classification",
                   "qualifierLabel": "anaivebayes",
                   "description": "Naive Bayes based Clustering",
                   "isCheckColumns": false,
                   "fixedInputColumns": false,
                   "fixedOutputColumns": false,
                   "readOnlyOutputColumns": false,
                   "ignoreInput": true,
                   "ignoreOutput": true,
                   "minPrevNodeCounts": 0,
                   "maxPrevNodeCounts": -1,
                   "minNextNodeCounts": 0,
                   "maxNextNodeCounts": -1,
                   "notAllowedPrevTypes": "",
                   "notAllowedNextTypes": "",
                   "notAllowedPrevNodes": "",
                   "notAllowedNextNodes": "",
                   "className":"NaiveBayesbasedClustering"
               },
               {
                   "type": "CLASSIFICATION",
                   "icon": CONSTANTS.CONTEXT_PATH + "/resources/images/ankus_icon_v2/kNN.png",
                   "jobType": "MAPREDUCE",
                   "identifier": "ALG_ANKUS_kNN",
                   "name": "kNN Classification",
                   "qualifierLabel": "akNN",
                   "description": "kNN based Clustering",
                   "isCheckColumns": false,
                   "fixedInputColumns": false,
                   "fixedOutputColumns": false,
                   "readOnlyOutputColumns": false,
                   "ignoreInput": true,
                   "ignoreOutput": true,
                   "minPrevNodeCounts": 0,
                   "maxPrevNodeCounts": -1,
                   "minNextNodeCounts": 0,
                   "maxNextNodeCounts": -1,
                   "notAllowedPrevTypes": "",
                   "notAllowedNextTypes": "",
                   "notAllowedPrevNodes": "",
                   "notAllowedNextNodes": "",
                   "className":"kNNBasedClustering"
               },        
               {
                   "type": "CLUSTERING",
                   "icon": CONSTANTS.CONTEXT_PATH + "/resources/images/ankus_icon_v2/ml_cluster_kmeans.png",
                   "jobType": "MAPREDUCE",
                   "identifier": "ALG_ANKUS_KMEANS",
                   "name": "K-Means Clustering",
                   "qualifierLabel": "akmeans",
                   "description": "K-Means based Clustering",
                   "isCheckColumns": false,
                   "fixedInputColumns": false,
                   "fixedOutputColumns": false,
                   "readOnlyOutputColumns": false,
                   "ignoreInput": true,
                   "ignoreOutput": true,
                   "minPrevNodeCounts": 0,
                   "maxPrevNodeCounts": -1,
                   "minNextNodeCounts": 0,
                   "maxNextNodeCounts": -1,
                   "notAllowedPrevTypes": "",
                   "notAllowedNextTypes": "",
                   "notAllowedPrevNodes": "",
                   "notAllowedNextNodes": "",
                   "className":"K-MeansBasedClustering"
               },
               {
                   "type": "CLUSTERING",
                   "icon": CONSTANTS.CONTEXT_PATH + "/resources/images/ankus_icon_v2/ml_cluster_em.png",
                   "jobType": "MAPREDUCE",
                   "identifier": "ALG_ANKUS_EM",
                   "name": "EM Clustering",
                   "qualifierLabel": "aem",
                   "description": "EM based Clustering",
                   "isCheckColumns": false,
                   "fixedInputColumns": false,
                   "fixedOutputColumns": false,
                   "readOnlyOutputColumns": false,
                   "ignoreInput": true,
                   "ignoreOutput": true,
                   "minPrevNodeCounts": 0,
                   "maxPrevNodeCounts": -1,
                   "minNextNodeCounts": 0,
                   "maxNextNodeCounts": -1,
                   "notAllowedPrevTypes": "",
                   "notAllowedNextTypes": "",
                   "notAllowedPrevNodes": "",
                   "notAllowedNextNodes": "",
                   "className":"EMBasedClustering"
               },
               {
                   "type": "CLUSTERING",
                   "icon": CONSTANTS.CONTEXT_PATH + "/resources/images/ankus_icon_v2/Canopy.png",
                   "jobType": "MAPREDUCE",
                   "identifier": "ALG_ANKUS_CANOPY",
                   "name": "Canopy Clustering",
                   "qualifierLabel": "acanopy",
                   "description": "Canopy based Clustering",
                   "isCheckColumns": false,
                   "fixedInputColumns": false,
                   "fixedOutputColumns": false,
                   "readOnlyOutputColumns": false,
                   "ignoreInput": true,
                   "ignoreOutput": true,
                   "minPrevNodeCounts": 0,
                   "maxPrevNodeCounts": -1,
                   "minNextNodeCounts": 0,
                   "maxNextNodeCounts": -1,
                   "notAllowedPrevTypes": "",
                   "notAllowedNextTypes": "",
                   "notAllowedPrevNodes": "",
                   "notAllowedNextNodes": "",
                   "className":"CanopyBasedClustering"
               },
               {
                   "type": "RECOMMENDATION",
                   "icon": CONSTANTS.CONTEXT_PATH + "/resources/images/ankus_icon_v2/recom_cf_corr.png",
                   "jobType": "MAPREDUCE",
                   "identifier": "ALG_ANKUS_CF_SIM",
                   "name": "CF based Similarity",
                   "qualifierLabel": "acfsim",
                   "description": "Collaborative Filtering based Similarity",
                   "isCheckColumns": false,
                   "fixedInputColumns": false,
                   "fixedOutputColumns": false,
                   "readOnlyOutputColumns": false,
                   "ignoreInput": true,
                   "ignoreOutput": true,
                   "minPrevNodeCounts": 0,
                   "maxPrevNodeCounts": -1,
                   "minNextNodeCounts": 0,
                   "maxNextNodeCounts": -1,
                   "notAllowedPrevTypes": "",
                   "notAllowedNextTypes": "",
                   "notAllowedPrevNodes": "",
                   "notAllowedNextNodes": "",
                   "className":"CollaborativeFilteringBasedSimilarity"
               },
               {
                   "type": "RECOMMENDATION",
                   "icon": CONSTANTS.CONTEXT_PATH + "/resources/images/ankus_icon_v2/recom_content_sim.png",
                   "jobType": "MAPREDUCE",
                   "identifier": "ALG_ANKUS_CONTENT_SIM",
                   "name": "Content based Similarity",
                   "qualifierLabel": "aconsim",
                   "description": "Content based Similarity",
                   "isCheckColumns": false,
                   "fixedInputColumns": false,
                   "fixedOutputColumns": false,
                   "readOnlyOutputColumns": false,
                   "ignoreInput": true,
                   "ignoreOutput": true,
                   "minPrevNodeCounts": 0,
                   "maxPrevNodeCounts": -1,
                   "minNextNodeCounts": 0,
                   "maxNextNodeCounts": -1,
                   "notAllowedPrevTypes": "",
                   "notAllowedNextTypes": "",
                   "notAllowedPrevNodes": "",
                   "notAllowedNextNodes": "",
                   "className":"ContentBasedSimilarity"
               },        
               //2015.03.tkkim
               {
                   "type": "RECOMMENDATION",
                   "icon": CONSTANTS.CONTEXT_PATH + "/resources/images/ankus_icon_v2/recom_gen.png",
                   "jobType": "MAPREDUCE",
                   "identifier": "ALG_ANKUS_CF_USER_ITEM_RECOMMEND",
                   "name": "User/Item Similarity based Recommendation",
                   "qualifierLabel": "aitemrec",
                   "description": "Collaborative Filtering User Item based Recommendation",
                   "isCheckColumns": false,
                   "fixedInputColumns": false,
                   "fixedOutputColumns": false,
                   "readOnlyOutputColumns": false,
                   "ignoreInput": true,
                   "ignoreOutput": true,
                   "minPrevNodeCounts": 0,
                   "maxPrevNodeCounts": -1,
                   "minNextNodeCounts": 0,
                   "maxNextNodeCounts": -1,
                   "notAllowedPrevTypes": "",
                   "notAllowedNextTypes": "",
                   "notAllowedPrevNodes": "",
                   "notAllowedNextNodes": "",
                   "className":"UserItemSimilarityBasedRecommendation"
               },       
               {
                   "type": "HADOOP",
                   "icon": CONSTANTS.CONTEXT_PATH + "/resources/images/etl/apache_pig.png",
                   "identifier": "HADOOP_PIG",
                   "name": MSG.DESIGNER_PIG,
                   "qualifierLabel": "pig",
                   "description": "Apache Pig Latin Script",
                   "isCheckColumns": false,
                   "fixedInputColumns": false,
                   "fixedOutputColumns": false,
                   "readOnlyOutputColumns": false,
                   "ignoreInput": true,
                   "ignoreOutput": true,
                   "minPrevNodeCounts": 1,
                   "maxPrevNodeCounts": 1,
                   "minNextNodeCounts": 1,
                   "maxNextNodeCounts": -1,
                   "notAllowedPrevTypes": "",
                   "notAllowedNextTypes": "",
                   "notAllowedPrevNodes": "",
                   "notAllowedNextNodes": "",
                   "className":"PIG"
               } 
           ]
   
});