/**
 *    Copyright ${license.git.copyrightYears} the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.apache.ibatis.submitted.awful_table;


import org.apache.ibatis.builder.xml.XMLMapperBuilder;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.ResultSetType;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.File;
import java.io.FilenameFilter;
import java.io.InputStream;

class TestWljs3 {
    private static SqlSessionFactory sqlSessionFactory;
    public static void main(String args[]) throws Exception {
      //String filePath="D:\\ky-mall-product-master\\dao\\ProductMapper.xml";
      String filePath=args[0];
      Configuration configuration = new Configuration();
      configuration.setDefaultResultSetType(ResultSetType.SCROLL_INSENSITIVE);
        String resource = "file:///"+filePath;
        System.out.println(resource);
        InputStream inputStream = Resources.getUrlAsStream(resource);
        XMLMapperBuilder builder = new XMLMapperBuilder(inputStream, configuration, resource, configuration.getSqlFragments());
        builder.parse();
        inputStream.close();
    }
}
